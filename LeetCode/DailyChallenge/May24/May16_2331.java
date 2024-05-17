package DailyChallenge.May24;

public class May16_2331 {
    public static void main(String[] args) {
        May16_2331 obj = new May16_2331();
        Integer[] inputArray = {2, 1, 3, null, null, 0, 1};
        TreeNode root = obj.createBinaryTree(inputArray, 0);
        System.out.println(obj.evaluateTree(root));
    }

    public boolean evaluateTree(TreeNode root) {
        if (root.val==0 || root.val==1) return root.val==1;

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);


        return root.val==3?(left&&right) : (left||right);
    }

    public TreeNode createBinaryTree(Integer[] array, int index) {
        TreeNode root = null;

        if (index < array.length) {
            Integer value = array[index];
            if (value != null) {
                root = new TreeNode(value);
                root.left = createBinaryTree(array, 2 * index + 1);
                root.right = createBinaryTree(array, 2 * index + 2);
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
