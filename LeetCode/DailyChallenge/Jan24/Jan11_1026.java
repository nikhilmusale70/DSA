package DailyChallenge.Jan24;

public class Jan11_1026 {
    public static void main(String[] args) {
        Jan11_1026 obj = new Jan11_1026();
        TreeNode root = obj.buildTree();
        System.out.println(obj.maxAncestorDiff(root));
    }
    public class TreeNode {
        int val;
        Jan11_1026.TreeNode left;
        Jan11_1026.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Jan11_1026.TreeNode left, Jan11_1026.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Jan11_1026.TreeNode buildTree() {
        // Build the tree manually
        Jan11_1026.TreeNode root = new Jan11_1026.TreeNode(1);
        root.left = new Jan11_1026.TreeNode(2);
        root.left.left = new Jan11_1026.TreeNode(0);
        root.left.left.right = new Jan11_1026.TreeNode(3);

        return root;
    }

    public int maxAncestorDiff(TreeNode root) {
        traversal(root.left, root.val, root.val);
        traversal(root.right, root.val, root.val);
        return max;
    }
    int max = 0;

    void traversal(TreeNode root, int currMax, int currMin) {
        if (root == null) return;
        max = Math.max(Math.abs(currMax - root.val), max);
        max = Math.max(Math.abs(currMin - root.val), max);
        if (currMax < root.val) currMax = root.val;
        if (currMin > root.val) currMin = root.val;

        traversal(root.left, currMax, currMin);
        traversal(root.right, currMax, currMin);
    }
}
