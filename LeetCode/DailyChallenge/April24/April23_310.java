package DailyChallenge.April24;

import java.util.*;

public class April23_310 {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        April23_310 obj = new April23_310();
        System.out.println(obj.findMinHeightTrees(n, edges));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = createAdjList(n, edges);
        int[] edgeCount = new int[n];
        Queue<Integer> leafs = new LinkedList<>();

        for (int i=0; i<n; i++){
            if(adjList.get(i).size()==1){
                leafs.add(i);
            }
            edgeCount[i] = adjList.get(i).size();
        }

        while(n>2){
            int size = leafs.size();
            n-=size;
            //we will now remove curr
            for(int i=0; i<size; i++){
                //decrement the edge count
                int poll = leafs.poll();
                for(int adj: adjList.get(poll)){
                    edgeCount[adj]--;
                    if(edgeCount[adj]==1){
                        leafs.add(adj);
                    }
                }
            }
        }

        return leafs.stream().toList();
    }

    public ArrayList<ArrayList<Integer>> createAdjList(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        return adjList;
    }
}
