package DailyChallenge.Dec23;




public class Dec8_606 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

    }
    public TreeNode createTree(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        // Connecting nodes to form the binary tree
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        return node1;
    }
    public static void main(String[] args) {
        Dec8_606 obj = new Dec8_606();
        System.out.println(obj.tree2str(obj.createTree()));
    }
    StringBuilder ans = new StringBuilder();

    public String tree2str(TreeNode root) {
        preOrder(root);
        return ans.toString();
    }
    void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        ans.append(root.val);
        if(root.left == null && root.right==null){
            return;
        }
        ans.append("(");
        preOrder(root.left);
        ans.append(")");
        if(root.right!=null){
            ans.append("(");
            preOrder(root.right);
            ans.append(")");
        }
    }
}
