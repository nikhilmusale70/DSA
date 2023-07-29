/*
*  Cycle in Directed Graph
Solved
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format
Return 1 if cycle is present else return 0.



Example Input
Input 1:

 A = 5
 B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:

 The given graph doesn't contain any cycle.

*/
package Graph1;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CycleInGraph {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1,4},{2,1},{4,3},{4,5},{2,3},{2,4},{1,5},{5,3},{2,5},{5,1},{4,2},{3,1},{5,4},{3,4},{1,3},{4,1},{3,5},{3,2},{5,2}};
        System.out.println(new CycleInGraph().solve(A, B));
    }
    public int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adjList = createAdjList(A, B);

        boolean[] visited = new boolean[A+1];
        boolean[] pathSoFar = new boolean[A+1];

        for(int i=1; i<=A; i++){
            if(!visited[i]){
                if(dfs(adjList, visited, pathSoFar, i)){
                    return 1;
                }
            }
        }
        return 0;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, boolean[] pathSoFar, int node){
        pathSoFar[node] = true;
        visited[node] = true;

        for(int i: adjList.get(node)){
            if(!visited[i]){
                if(dfs(adjList, visited, pathSoFar, i)){
                    return true;
                }
            }
            else if(pathSoFar[i]) return true;
        }

        pathSoFar[node] = false;
        return false;
    }

    ArrayList<ArrayList<Integer>> createAdjList(int A, int[][] B){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=A; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] arr: B){
            adjList.get(arr[0]).add(arr[1]);
        }
        return adjList;
    }
}
