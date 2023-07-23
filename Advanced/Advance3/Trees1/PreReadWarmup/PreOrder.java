package Trees1.PreReadWarmup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PreOrder {
    public static class TreeNode {
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
        TreeNode root = creatTree();
        System.out.println(solve(root));
    }

    public static TreeNode creatTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        return root;
    }

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode curr = q.remove();



            if(curr==null){
                if(q.isEmpty()){
                    return ans;
                }
                else{
                    q.add(null);
                }
                continue;
            }
            System.out.println(curr.val);

            if(! (curr.val==-1) ){
                if(curr.left==null) {
                    curr.left = new TreeNode(-1);
                }

                if(curr.right==null){
                    curr.right = new TreeNode(-1);
                }
            }

            ans.add(curr.val);
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }

        return ans;
    }

}
