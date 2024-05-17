package DailyChallenge.May24;

import java.util.LinkedList;
import java.util.Queue;

public class May17_1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        helper(root,target);
        if(checkIfNodeIsLeaf(root) && root.val==target) return null;
        return root;
    }
    void helper(TreeNode root, int target){
        if(root==null){
            return;
        }
        helper(root.left, target);
        helper(root.right, target);

        if(checkIfNodeIsLeaf(root.left) && root.left.val==target){
            root.left = null;
        }
        if(checkIfNodeIsLeaf(root.right) && root.right.val==target){
            root.right = null;
        }
    }

    boolean checkIfNodeIsLeaf(TreeNode node){
        if(node == null) return false;
        return node.left==null && node.right==null;
    }

    public static void main(String[] args) {
        May17_1325 obj = new May17_1325();
        Integer[] inputArray = {1,3,3,3,2};
        TreeNode root = obj.createBinaryTree(inputArray, 0);
        obj.printTree(root);
        obj.printTree(obj.removeLeafNodes(root, 2));
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
    // Function to print the tree
    public  void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.val + " ");

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            System.out.println();
        }
    }

}
