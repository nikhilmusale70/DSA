package DailyChallenge.Feb24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Feb29_1809 {
    public static void main(String[] args) {
        Integer[] inputArray = {11,18,14,3,7,null,null,null,null,18,null,6};
        Feb29_1809 obj = new Feb29_1809();

        TreeNode root = obj.createBinaryTree(inputArray);
        // Now you can use the 'root' node to traverse or perform any other operations on the binary tree

        System.out.println(obj.isEvenOddTree(root));
    }

    public boolean isEvenOddTree(TreeNode root) {
        List<Integer> levelOrder = traverseLevel(root);
        int currentLevel = 0;
        if(levelOrder.get(0) % 2 == 0) return false;

        for(int i = 2; i < levelOrder.size(); i++) {
            currentLevel++;
            while(i < levelOrder.size() - 1 && levelOrder.get(i) != 0) {
                int current = levelOrder.get(i);
                int next = levelOrder.get(i + 1);
                // Odd levels
                if(next != 0 && currentLevel % 2 == 0 && current >= next) return false;
                // Even levels
                if(next != 0 && currentLevel % 2 != 0 && current <= next) return false;

                if(current % 2 == currentLevel % 2) return false;
                i++;
            }
        }
        if(levelOrder.get(levelOrder.size() - 1) % 2 == currentLevel % 2) return false;
        return true;
    }

    List<Integer> traverseLevel(TreeNode root){
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if(current == null) {
                if(queue.isEmpty()) return result;
                result.add(0);
                queue.add(null);
                continue;
            }
            result.add(current.val);
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return result;
    }

    public TreeNode createBinaryTree(Integer[] inputArray) {
        if (inputArray == null || inputArray.length == 0 || inputArray[0] == null)
            return null;

        TreeNode root = new TreeNode(inputArray[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < inputArray.length) {
            TreeNode current = queue.poll();

            Integer leftVal = inputArray[i++];
            if (leftVal != null) {
                current.left = new TreeNode(leftVal);
                queue.offer(current.left);
            }

            if (i < inputArray.length) {
                Integer rightVal = inputArray[i++];
                if (rightVal != null) {
                    current.right = new TreeNode(rightVal);
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
