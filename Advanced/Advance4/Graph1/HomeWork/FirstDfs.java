/*
* First Depth First Search
Solved
feature icon
Using hints is now penalty free
Use Hint
Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.



Problem Constraints
1 <= N <= 100000



Input Format
First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format
Return 1 if reachable, 0 otherwise.



Example Input
Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:

 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
*/
package Graph1.HomeWork;

import java.util.ArrayList;

public class FirstDfs {
    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        int B = 1;
        int C = 2;
        System.out.println(new FirstDfs().solve(A, B, C));
    }
    public int solve(int[] A, final int B, final int C) {
        //check if b is reachable from C
        ArrayList<ArrayList<Integer>> adjList = createAdjList(A);
        flag=0;
        boolean[] visited = new boolean[A.length+1];
        dfs(adjList, C, B, visited);

        return flag;
    }
    int flag;
    void dfs(ArrayList<ArrayList<Integer>> adjList, int source, int target, boolean[] visited){
        visited[source] = true;
        if(source==target)
            flag=1;
        for(int i: adjList.get(source)){
            if(!visited[i]){
                dfs(adjList, i, target, visited);
            }
        }
    }

    ArrayList<ArrayList<Integer>> createAdjList(int[] A){
//        There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also,
//        it's guaranteed that A[i] <= i for every 1 <= i < N.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=A.length; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=1; i<A.length; i++){
            adjList.get(A[i]).add(i+1);
        }
        return adjList;
    }
}
