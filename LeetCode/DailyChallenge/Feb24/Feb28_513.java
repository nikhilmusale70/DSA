package DailyChallenge.Feb24;

public class Feb28_513 {
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
    public static void main(String[] args) {
        //create tree and call our function find bottom left value
    }

    //answer
    int ans = 0;
    int highestLevel = -1;
    public int findBottomLeftValue(TreeNode root) {
        findLeftVal(root, 0);
        return ans;
    }

    void findLeftVal(TreeNode root, int currLevel){
        if(root==null) return;
        if(currLevel>highestLevel){
            highestLevel = currLevel;
            ans = root.val;
        }
        findLeftVal(root.left, currLevel+1);
        findLeftVal(root.right, currLevel+1);
    }
}
