/*
* Path in Directed Graph
Solved
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

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
Return 1 if path exists between node 1 to node A else return 0.



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

 0
Output 2:

 1


Example Explanation
Explanation 1:

 The given doens't contain any path from node 1 to node 5 so we will return 0.
Explanation 2:

 Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.

*/
package Graph1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsDfs {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {   {1, 2},
                        {4, 1},
                        {2, 4},
                        {3, 4},
                        {5, 2},
                        {1, 3} };
        System.out.println(new BfsDfs().solve(A, B));
    }
    public int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adjList = createAdjList(A, B);
        boolean[] visited = new boolean[A+1];
        dfs(adjList, 1, A, visited);
        return flag;
    }
    int flag = 0;
    void dfs(ArrayList<ArrayList<Integer>> adjList, int source, int target, boolean[] visited){
        if(target == source) {
            flag=1;
            return;
        }
        if(visited[source]) return;
        visited[source] = true;
        for(int elem: adjList.get(source)){
            if(!visited[elem])
                dfs(adjList, elem, target, visited);

        }
    }
    void bfs(ArrayList<ArrayList<Integer>> adjList, int source, int target){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];
        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int elemToRemove = q.remove();
            for(int currElem: adjList.get(elemToRemove)){
                if(target == currElem){
                    flag = 1;
                    return;
                }
                if(!visited[currElem]){
                    q.add(currElem);
                    visited[currElem] = true;
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> createAdjList(int numOfNode, int[][] B){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=numOfNode; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] arr: B){
            adjList.get(arr[0]).add(arr[1]);
        }
        return adjList;
    }
}
