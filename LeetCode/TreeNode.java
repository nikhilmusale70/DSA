import com.sun.source.tree.Tree;

public class TreeNode {
    String value;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(String value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Example usage:
    public static void main(String[] args) {
        TreeNode root = new TreeNode("Root");
        root.leftChild = new TreeNode("Left Child");
        root.rightChild = new TreeNode("Right Child");

        // Subtrees for the left child
        root.leftChild.leftChild = new TreeNode("Left-Left Child");
        root.leftChild.rightChild = new TreeNode("Left-Right Child");

        // Subtrees for the right child
        root.rightChild.leftChild = new TreeNode("Right-Left Child");
        root.rightChild.rightChild = new TreeNode("Right-Right Child");
    }

    TreeNode RamBhagwan;
    public void findBhagwanRam(TreeNode root){
        if(root==null) return;
        if(root.value == "Bhagwan Ram"){
            if(root.leftChild!=null && root.rightChild!=null && root.leftChild.value == "luv" && root.rightChild.value=="kush"){
                RamBhagwan = root;
            }
        }
        findBhagwanRam(root.leftChild);
        findBhagwanRam(root.rightChild);
    }
}