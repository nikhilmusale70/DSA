package DailyChallenge.April24;

public class April14_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        traversal(root);
        return sum;
    }
    int sum = 0;
    public void traversal(TreeNode root){
        if(root==null) return;

        if(root.left != null && root.left.left == null && root.left.right==null){
            sum += root.left.val;
        }
        traversal(root.left);
        traversal(root.right);
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
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        April14_404 obj = new April14_404();
        System.out.println(obj.sumOfLeftLeaves(root));
    }
}
