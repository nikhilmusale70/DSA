package DailyChallenge.April24;

public class April17_988 {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3_1 = new TreeNode(3);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node4_2 = new TreeNode(4);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3_1;
        node1.right = node4_1;
        node2.left = node3_2;
        node2.right = node4_2;

        April17_988 obj = new April17_988();
        System.out.println(obj.smallestFromLeaf(node0));
    }

    // Variable to store the smallest leaf string found
    private String smallestLeafString = null;

    public String smallestFromLeaf(TreeNode root) {
        // Start DFS traversal from the root node
        depthFirstSearch(root, new StringBuilder());
        return smallestLeafString;
    }

    // Depth-first search traversal
    private void depthFirstSearch(TreeNode node, StringBuilder currentPath) {
        if (node == null) {
            return; // Base case: node is null
        }

        // Append the current node's character value to the path
        currentPath.insert(0, (char) ('a' + node.val));

        // Check if the current node is a leaf node
        if (node.left == null && node.right == null) {
            // Update the smallest leaf string found so far
            updateSmallestLeafString(currentPath.toString());
        } else {
            // Recursive calls for left and right child nodes
            depthFirstSearch(node.left, currentPath);
            depthFirstSearch(node.right, currentPath);
        }

        // Remove the current node's character from the path before returning
        currentPath.deleteCharAt(0);
    }

    // Update the smallest leaf string
    private void updateSmallestLeafString(String currentPath) {
        if (smallestLeafString == null || currentPath.compareTo(smallestLeafString) < 0) {
            smallestLeafString = currentPath;
        }
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
