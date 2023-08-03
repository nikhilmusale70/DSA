package Graph2;

import java.util.ArrayList;

/*
* Construct Roads
Solved
feature icon
Using hints is now penalty free
Use Hint
Problem Description
A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.

Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.

Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.

NOTE: All cities can be visited from any city.



Problem Constraints
1 <= A <= 105

1 <= B[i][0], B[i][1] <= N



Input Format
First argument is an integer A denoting the number of cities, N.

Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .



Output Format
Return an integer denoting the maximum number of roads king can construct.



Example Input
Input 1:

 A = 3
 B = [
       [1, 2]
       [1, 3]
     ]
Input 2:

 A = 5
 B = [
       [1, 3]
       [1, 4]
       [3, 2]
       [3, 5]
     ]


Example Output
Output 1:

 0
Output 2:

 2


Example Explanation
Explanation 1:

 We can't construct any new roads such that the country remains bipartite.
Explanation 2:

 We can add two roads between cities (4, 2) and (4, 5).
*/
public class ConstructRoads {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1, 3},
                {1, 4},
                {3, 2},
                {3, 5}
        };
        System.out.println(new ConstructRoads().solve(A, B));
    }

    long mod = 1000000007;
    public int solve(int A, int[][] B) {
        //so we have A cities, paint A cities with 2 color
        //then get the sets and multiple them and then subtract with A-1
        int[] color = new int[A+1];
        ArrayList<ArrayList<Integer>> adjList = createAdjList(A,B);
        set1 = 0;
        set2 = 0;
        dfsAndColor(adjList, color, 1, 1);
        long cnt =(set1*set2)%mod;

        return (int) (cnt - (A-1));
    }

    long set1;
    long set2;
    void dfsAndColor(ArrayList<ArrayList<Integer>> adjList, int[] color, int source, int col){
        if(col==1){
            set1++;
            set1 %= mod;
        }
        else{
            set2++;
            set2 %= mod;
        }
        color[source] = col;
        for(int i: adjList.get(source)){
            if(color[i]==0) {
                dfsAndColor(adjList, color, i, 3 - col);
            }
        }
    }

    ArrayList<ArrayList<Integer>> createAdjList(int A, int[][] B){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=A; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] arr: B){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        return adjList;
    }
}
