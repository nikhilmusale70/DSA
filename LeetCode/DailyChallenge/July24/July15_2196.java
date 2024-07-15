package DailyChallenge.July24;

import java.util.*;

public class July15_2196 {
    public static void main(String[] args) {
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        printTreeDiagram(new July15_2196().createBinaryTree(descriptions));
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> tree = new HashMap<>();
        Set<Integer> childs = new HashSet<>();

        for(int[] arr: descriptions){
            int child = arr[1];
            int parent = arr[0];
            boolean isLeft = arr[2]==1;
            childs.add(child);

            //check in map if both parent and child node is already created
            if(!tree.containsKey(parent)){
                tree.put(parent, new TreeNode(parent));
            }
            if(!tree.containsKey(child)){
                tree.put(child, new TreeNode(child));
            }

            //now we have both the nodes, aka child and parent
            //make connection
            if(isLeft){
                tree.get(parent).left = tree.get(child);
            }
            else{
                tree.get(parent).right = tree.get(child);
            }
        }

        for(int[] arr: descriptions){
            if(!childs.contains(arr[0])){
                return tree.get(arr[0]);
            }
        }

        return null;
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
    public static void printTreeDiagram(TreeNode root) {
        if (root == null) {
            return;
        }

        List<List<String>> lines = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();

        level.add(root);
        int nodesInThisLevel = 1;
        int widest = 0;

        while (nodesInThisLevel != 0) {
            List<String> line = new ArrayList<>();
            nodesInThisLevel = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(n.val);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nodesInThisLevel++;
                    if (n.right != null) nodesInThisLevel++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perPiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int half = (int) Math.floor(perPiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = '|';
                        }
                    }
                    System.out.print(c);

                    if (line.get(j) == null) {
                        for (int k = 0; k < perPiece - 1; k++) {
                            System.out.print(' ');
                        }
                    } else {
                        for (int k = 0; k < half; k++) {
                            System.out.print(j % 2 == 0 ? ' ' : '-');
                        }
                        System.out.print(j % 2 == 0 ? '|' : '|');
                        for (int k = 0; k < half; k++) {
                            System.out.print(j % 2 == 0 ? '-' : ' ');
                        }
                    }
                }
                System.out.println();
            }

            for (String f : line) {
                if (f == null) f = "";
                float a = (float) Math.ceil(perPiece / 2f - f.length() / 2f);
                float b = (float) Math.floor(perPiece / 2f - f.length() / 2f);

                for (int j = 0; j < a; j++) {
                    System.out.print(' ');
                }
                System.out.print(f);
                for (int j = 0; j < b; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();

            perPiece /= 2;
        }
    }
}
