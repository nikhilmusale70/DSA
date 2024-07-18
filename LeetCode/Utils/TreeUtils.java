package Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {
    TreeNode root;

    // Function to create a binary tree from an array
    public TreeNode createBinaryTreeFromArray(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
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

        int perPiece = lines.getLast().size() * (widest + 4);
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
                        System.out.print('|');
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
