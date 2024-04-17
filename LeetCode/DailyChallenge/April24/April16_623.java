package DailyChallenge.April24;

public class April16_623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        traversal(root, val, depth);
        return root;
    }

    void traversal(TreeNode root, int val, int dept){
        if(root==null)return;

        if(dept==2){
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        }

        traversal(root.left, val, dept-1);
        traversal(root.right, val, dept-1);
    }
    public static class TreeNode {
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
