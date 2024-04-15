package DailyChallenge.April24;

public class April15_129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    int dfs(TreeNode root, int numTillNow){
        if(root==null) return 0;
        numTillNow = numTillNow * 10 + root.val;

        // Check if the current node is a leaf node
        if(root.left == null && root.right == null){
            return numTillNow;
        }
        return dfs(root.left, numTillNow) + dfs(root.right, numTillNow);
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
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(1);
        TreeNode node4 = new TreeNode(5);
        TreeNode node3 = new TreeNode(0);
        TreeNode node2 = new TreeNode(9, node4, node5);
        TreeNode root = new TreeNode(4, node2, node3);

        April15_129 obj = new April15_129();
        System.out.println(obj.sumNumbers(root));
    }

}
