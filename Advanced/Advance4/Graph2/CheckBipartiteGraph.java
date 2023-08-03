package Graph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* Check Bipartite Graph
Solved
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].

Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints
1 <= A <= 100000

1 <= M <= min(A*(A-1)/2,200000)

0 <= B[i][0],B[i][1] < A



Input Format
The first argument given is an integer A.

The second argument given is the matrix B.



Output Format
Return 1 if the given graph is bipartide else return 0.



Example Input
Input 1:

A = 2
B = [ [0, 1] ]
Input 2:

A = 3
B = [ [0, 1], [0, 2], [1, 2] ]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

Put 0 and 1 into 2 different subsets.
Explanation 2:


It is impossible to break the graph down to make two different subsets for bipartite matching
*/
public class CheckBipartiteGraph {
    public static void main(String[] args) {
        int A = 69;
        int[][] B = {{40,64},{29,60},{26,43},{29,32},{32,47},{42,61},{48,61},{26,52},{24,34},{35,55},{14,60},{53,62},{61,63},{13,53},{16,62},{62,64},{56,68},{2,23},{7,55},{3,60},{32,51},{2,18},{1,43},{5,37},{4,51},{27,55},{15,30},{13,65},{7,13},{28,48},{36,50},{3,7},{30,46},{1,35},{47,68},{37,62},{37,58},{8,22},{19,45},{6,64},{9,55},{32,46},{48,56},{26,59},{8,46},{44,66},{50,60},{40,46},{30,68},{26,44},{5,32},{9,34},{36,45},{47,48}};
        System.out.println(new CheckBipartiteGraph().solve(A, B));
        System.out.println("answer should be: " + 0);
    }
    public int solve(int A, int[][] B) {
        //lets first make the adjList for the graph
        ArrayList<ArrayList<Integer>> adjList = createAdjList(A, B);
        int[] color = new int[A];

        //we will be using 1 and 2 to fill the colors
        //we have to start coloring from 0 to A-1
        for(int i=0; i<A; i++){
            if(color[i]==0){
                if(!bfsIsBipartite(i, adjList, color)){
                    return 0;
                }
            }
        }
        return 1;
    }

    boolean bfsIsBipartite(int source, ArrayList<ArrayList<Integer>> adjList, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        color[0] = 1;

        while(!q.isEmpty()){
            int elemToRemove = q.remove();
            int parentColor = color[elemToRemove];

            for(int nodes: adjList.get(elemToRemove)){
                if(color[nodes]==0){
                    //not colored, that also implies not visited
                    q.add(nodes);
                    color[nodes] = parentColor==1?2:1;
                }
                if(color[nodes] == parentColor){
                    return false;
                }
            }
        }

        return true;
    }

    ArrayList<ArrayList<Integer>> createAdjList(int numOfNodes, int[][] B){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numOfNodes; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] arr: B){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        return adjList;
    }
}
