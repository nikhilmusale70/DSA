package Trees1.Assignments;

import java.util.HashMap;

public class BTPreIn {
     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] B = {2, 1, 3};
        BTPreIn obj = new BTPreIn();
        TreeNode bt = obj.buildTree(A, B);
    }
    public TreeNode buildTree(int[] A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<B.length; i++){
            hm.put(B[i], i);
        }
        return constBt(A, 0, A.length-1, B, 0, B.length-1, hm);
    }


    TreeNode constBt(int[] A, int ps, int pe, int[] B, int is, int ie, HashMap<Integer, Integer> hm) {
        if (is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(B[ps]);

        if (is == ie || ps == pe) return root;

        //lets find the index of root inside inorder
        int idx = hm.get(root.val);
        int leftElems = idx - is;

        root.left = constBt(A, ps + 1, ps + leftElems, B, is, idx - 1, hm);
        root.right = constBt(A, ps + 1 + leftElems, pe, B, idx + 1, ie, hm);

        return root;
    }
}
