package DailyChallenge.oct24;

import Utils.TreeNode;
import Utils.TreeUtils;
import com.sun.source.tree.Tree;

import java.util.*;

public class oct22_2583 {
    public static void main(String[] args) {
        oct22_2583 obj = new oct22_2583();
        Integer[] arr = {1,2,null,3};
        TreeNode root = new TreeUtils().createBinaryTreeFromArray(arr);
        TreeUtils.printTreeDiagram(root);
        System.out.println(obj.kthLargestLevelSum(root, 2));
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> maxHeap = levelOrderTravel(root);
        while(!maxHeap.isEmpty() && k>1){
            maxHeap.remove();
            k--;
        }
        return maxHeap.isEmpty()?-1:maxHeap.peek();
    }


    PriorityQueue<Long> levelOrderTravel(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(root);
        queue.add(null);
        long levelSum = 0;
        while(!queue.isEmpty()){
            if(queue.getFirst()==null){
                maxHeap.add(levelSum);
                levelSum = 0;
                queue.remove();
                queue.add(null);
                if(queue.peek()==null) return maxHeap;
            }
            TreeNode curr = queue.remove();
            levelSum += curr.val;
            if(curr.left!=null)
                queue.add(curr.left);
            if(curr.right!=null)
                queue.add(curr.right);
        }
        return maxHeap;
    }
}
