package Trees1.PreReadWarmup;

import java.util.*;

/*
Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the inorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]


Example Explanation
Explanation 1:

 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:

 The Inorder Traversal of the given tree is [6, 1, 3, 2].
*/
public class PostOrder {

    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        Stack<TreeNode> stk = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        stk.push(A);

        while(!stk.isEmpty()){
            TreeNode curr = stk.pop();

            if(curr.right!=null){
                stk.push(curr.right);
            }
            if(curr.left!=null){
                stk.push(curr.left);
            }
            ans.add(curr.val);
        }
        return ans;
    }
    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = createTree();
        printAsciiTree(root, "", true);

        System.out.println(preorderTraversal(root));
    }



    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        return root;
    }

    public static void printAsciiTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }
        printAsciiTree(node.right, prefix + (isLeft ? "│ " : " "), false);
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);
        printAsciiTree(node.left, prefix + (isLeft ? " " : "│ "), true);
    }



    //      Definition for binary tree
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
}
