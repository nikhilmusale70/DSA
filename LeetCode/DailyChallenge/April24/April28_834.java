package DailyChallenge.April24;

import java.util.*;

public class April28_834 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        April28_834 obj = new April28_834();
        System.out.println(Arrays.toString(obj.sumOfDistancesInTree(n, edges)));
    }
    private Map<Integer, List<Integer>> graph;
    private int[] count;
    private int[] res;

    // Depth-first search to calculate count and res arrays
    private void dfs(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child]; // Update count array
                res[node] += res[child] + count[child]; // Update res array
            }
        }
    }

    // Depth-first search to update res array after count array is calculated
    private void dfs2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                // Update res array based on the parent's res and count
                res[child] = res[node] - count[child] + (count.length - count[child]);
                dfs2(child, node);
            }
        }
    }

    // Main method to calculate sum of distances in a tree
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // Initialize graph, count, and res arrays
        graph = new HashMap<>();
        count = new int[n];
        res = new int[n];
        Arrays.fill(count, 1);

        // Create adjacency list representation of the graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Perform depth-first searches to calculate count and res arrays
        dfs(0, -1);
        dfs2(0, -1);

        return res;
    }
}
