package DailyChallenge.Aug24;

import java.util.ArrayList;
import java.util.List;

public class Aug27_1514 {
    public static void main(String[] args) {
        Aug27_1514 obj = new Aug27_1514();
        int n = 5;
        int[][] edges = {{0,1},{1,2},{2,3},{0,4},{4,3}};
        double[] succProb = {0.9,0.1,0.9,0.7,0.95};
        int start = 0, end = 3;
        System.out.println(obj.maxProbability(n, edges, succProb, start, end));
    }

    class Pair{
        int node;
        double value;
        Pair(int node, double value){
            this.node = node;
            this.value = value;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adjList = createAdjacencyList(edges, n, succProb);
        maxProb = 0.0;
        boolean[] visited = new boolean[n];
        dfs(adjList, start_node, end_node, visited, 1);
        return maxProb;
    }
    double maxProb;

    void dfs(List<List<Pair>> adjList, int from, int to, boolean[] visited, double prob){
        if(from==to){
            maxProb = Math.max(maxProb, prob);
            return;
        }
        visited[from] = true;

        for(Pair curr: adjList.get(from)){
            int node = curr.node;
            double probablity = curr.value;
            if(!visited[node]){
                dfs(adjList, node, to, visited, prob * probablity);
            }
        }
    }

    List<List<Pair>> createAdjacencyList(int[][] edges, int n, double[] succProb){
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        int i = 0;
        for(int[] edge: edges){
            adjList.get(edge[0]).add(new Pair(edge[1], succProb[i]));
            adjList.get(edge[1]).add(new Pair(edge[0], succProb[i]));
            i++;
        }
        return adjList;
    }



}
