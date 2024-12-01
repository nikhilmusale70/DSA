package DailyChallenge.Nov;

import java.util.*;

public class nov27_3243 {
    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{2,4},{0,2},{0,4}};
        nov27_3243 obj = new nov27_3243();
        System.out.println(Arrays.toString(obj.shortestDistanceAfterQueries(n, queries)));
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            adjList.get(i).add(i+1);
        }

        // Initialize result array
        int[] ans = new int[queries.length];
        int idx = 0;

        for (int[] query : queries) {
            int from = query[0], to = query[1];
            adjList.get(from).add(to); // Add edge

            // Run BFS to compute shortest distance
            ans[idx++] = bfs(0, n - 1, adjList, n);
        }
        return ans;
    }

    private int bfs(int source, int target, List<List<Integer>> adjList, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, -1); // Initialize distances to -1 (unreachable)

        queue.add(source);
        distance[source] = 0; // Distance to the source is 0

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : adjList.get(curr)) {
                if (distance[neighbor] == -1) { // Not visited
                    distance[neighbor] = distance[curr] + 1;
                    if (neighbor == target) {
                        return distance[target];
                    }
                    queue.add(neighbor);
                }
            }
        }
        return -1; // Target not reachable
    }
}
