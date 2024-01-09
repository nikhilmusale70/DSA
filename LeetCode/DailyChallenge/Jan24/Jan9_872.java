package DailyChallenge.Jan24;

import java.util.ArrayList;

public class Jan9_872 {
    public static void main(String[] args) {

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        preOrderTraversal(root1, list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        preOrderTraversal(root2, list2);

        if(list1.size() != list2.size()) return false;
        return list1.equals(list2);
    }

    void preOrderTraversal(TreeNode root, ArrayList<Integer> ans){
        if(root==null) return;
        if(root.left==null && root.right==null) ans.add(root.val);
        preOrderTraversal(root.left, ans);
        preOrderTraversal(root.right, ans);
    }
}
