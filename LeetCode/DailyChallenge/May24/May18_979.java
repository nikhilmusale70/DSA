package DailyChallenge.May24;

public class May18_979 {
    class Solution {
        int moves;
        public int distributeCoins(TreeNode root) {
            moves = 0;
            helper(root);
            return moves;

        }
        int helper(TreeNode root){
            if(root==null) return 0;

            int left = helper(root.left);
            int right = helper(root.right);

            moves += Math.abs(left) + Math.abs(right);

            return (root.val -1) + left + right;
        }
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
