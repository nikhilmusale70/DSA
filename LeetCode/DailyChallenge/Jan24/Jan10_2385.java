package DailyChallenge.Jan24;

public class Jan10_2385 {
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

    public TreeNode buildTree() {
        // Build the tree manually
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);


        return root;
    }
    public static void main(String[] args) {
       Jan10_2385 obj = new Jan10_2385();

       TreeNode root = obj.buildTree();
        System.out.println(obj.amountOfTime(root, 3));
    }
    boolean subtreeMore = false;

    public int amountOfTime(TreeNode root, int start) {
        int left = heightOfTree(root.left, start, 0);
        int right = heightOfTree(root.right, start, 0);
        return subtreeMore?Math.max(left, right): left+right;
    }

    int heightOfTree(TreeNode root, int start, int count){
        if(root == null) return 0;
        if(root.val == start){
            int subtreeH = Math.max(heightOfTree(root.left, start, count), heightOfTree(root.right, start, count));
            if(subtreeH>count+1) subtreeMore = true;
            return Math.max(count, subtreeH);
        }
        int leftSubtree  = 1 + heightOfTree(root.left , start, count+1);
        int rightSubtree = 1 + heightOfTree(root.right, start, count+1);

        return Math.max(leftSubtree, rightSubtree);
    }
}
