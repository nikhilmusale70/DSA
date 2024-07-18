package DailyChallenge.July24;

import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class July18_1530 {
    public static void main(String[] args) {
        TreeUtils treeUtils = new TreeUtils();
        Integer[] arr = {1, 2, 3, null, 4};
        TreeNode root = treeUtils.createBinaryTreeFromArray(arr);
        TreeUtils.printTreeDiagram(root);
        int distance = 3;

        July18_1530 obj = new July18_1530();
        System.out.println(obj.countPairs(root, distance));
    }
    int dis;
    int pairCount;

    public int countPairs(TreeNode root, int distance) {
        dis = distance;
        pairCount = 0;
        distanceOfLeaf(root);
        return pairCount;
    }

    List<Integer> distanceOfLeaf(TreeNode root) {
        if (root == null) return new ArrayList<>();

        if (root.left == null && root.right == null) {
            // leaf node
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            return ans;
        }

        List<Integer> leftLeafsDistance = distanceOfLeaf(root.left);
        List<Integer> rightLeafsDistance = distanceOfLeaf(root.right);

        pairsFrom2List(leftLeafsDistance, rightLeafsDistance);

        List<Integer> ans = new ArrayList<>();
        ans.addAll(leftLeafsDistance.stream().map(distance -> distance + 1).toList());
        ans.addAll(rightLeafsDistance.stream().map(distance -> distance + 1).toList());
        return ans;
    }

    void pairsFrom2List(List<Integer> listOne, List<Integer> listTwo) {
        if (listOne == null || listTwo == null) return;

        for (int first : listOne) {
            for (int second : listTwo) {
                int currDistance = first + second;
                if (currDistance <= dis) {
                    pairCount++;
                }
            }
        }
    }
}
