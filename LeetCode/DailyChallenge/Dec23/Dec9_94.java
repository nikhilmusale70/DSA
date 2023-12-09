package DailyChallenge.Dec23;

import java.util.ArrayList;
import java.util.List;

public class Dec9_94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

    }
    List<Integer> arr;
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();

        arr = new ArrayList<Integer>();
        inorder(root);
        return arr;
    }

    void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
}
