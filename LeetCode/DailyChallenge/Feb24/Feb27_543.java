package DailyChallenge.Feb24;

public class Feb27_543 {
    private int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateMaxDepth(root);
        return maxDiameter;
    }

    private int calculateMaxDepth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = calculateMaxDepth(node.left);
        int rightDepth = calculateMaxDepth(node.right);

        int currentDiameter = leftDepth + rightDepth;
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
