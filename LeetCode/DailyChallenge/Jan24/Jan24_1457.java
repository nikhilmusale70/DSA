package DailyChallenge.Jan24;

public class Jan24_1457 {
    static class TreeNode {
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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3, new TreeNode(3), new TreeNode(1));
        root.right = new TreeNode(1, null, new TreeNode(1));

        Jan24_1457 obj = new Jan24_1457();
        System.out.println(obj.pseudoPalindromicPaths(root));
    }

    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root, new int[10]);
        return ans;
    }
    void helper(TreeNode root, int[] freqArr){
        if(root==null){
            return;
        }
        int[] clone = freqArr.clone();
        clone[root.val]++;

        if(root.left==null && root.right==null){
            if(checkFreqArr(clone)){
                ans++;
            }
            return;
        }
        helper(root.left, clone);
        helper(root.right, clone);
    }

    boolean checkFreqArr(int[] freqArr){
        boolean flag = false;
        for(int i=1; i<freqArr.length; i++){
            if(freqArr[i]%2 != 0){
                if(flag){
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }
}
