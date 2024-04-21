package DailyChallenge.April24;

import java.util.ArrayList;
import java.util.List;

public class April21_1971 {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int n = 6;
        int source = 0;
        int destination = 5;

        April21_1971 obj = new April21_1971();
        System.out.println(obj.validPath(n, edges, source, destination));
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }

        dfs(source, adjList, visited);
        return visited[destination];
    }
    void dfs(int source, List<List<Integer>> adjList, boolean[] visited){
        visited[source] = true;

        List<Integer> sr = adjList.get(source);
        for (Integer integer : sr) {
            if(!visited[integer]){
                dfs(integer, adjList, visited);
            }
        }
    }
}
