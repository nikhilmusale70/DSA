package Graph2;

import Utils.ScaUtils;

import java.util.*;

/*
Rotten Oranges
Solved
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input
Input 1:

A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Input 2:


A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]


Example Output
Output 1:

 4
Output 2:

 -1


Example Explanation
Explanation 1:

Minute 0: [ [2, 1, 1]
            [1, 1, 0]
            [0, 1, 1] ]
Minute 1: [ [2, 2, 1]
            [2, 1, 0]
            [0, 1, 1] ]
Minute 2: [ [2, 2, 2]
            [2, 2, 0]
            [0, 1, 1] ]
Minute 3: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 1] ]
Minute 4: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 2] ]
At Minute 4, all the oranges are rotten.
Explanation 2:

The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.

*/
public class RottenOranges {
    public static void main(String[] args) {
        int[][] A = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
                    };
        System.out.println(new RottenOranges().solve(A));
    }

    class Pair{
        int x, y;
        Pair(int corX, int corY){
            this.x = corX;
            this.y = corY;
        }
    }
    public int solve(int[][] A) {
        int[][] time = new int[A.length][A[0].length];
        for(int[] arr: time){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        //just take all the rotten mangoes and start bfs from them
        Queue<Pair> rottenQueue = new LinkedList<>();
        boolean[][] visited = new boolean[A.length][A[0].length];

        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[i].length; j++){
                if (A[i][j]==0) time[i][j]=0;

                if(A[i][j]==2){
                    time[i][j] = 0;
                    rottenQueue.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        //queue is added lets do our BFS traversal
        int[] cordX = {1,-1,0,0};
        int[] cordY = {0,0,-1,1};

        while(!rottenQueue.isEmpty()){
            Pair currElem = rottenQueue.remove();

            for(int i=0; i<4; i++){
                int x = currElem.x + cordX[i];
                int y = currElem.y + cordY[i];

                if(isValid(x, y, A.length, A[0].length, visited, A)){
                    rottenQueue.add(new Pair(x,y));
                    time[x][y] = 1 + time[currElem.x][currElem.y];
                    visited[x][y] = true;
                }
            }
        }
        //now we have rotten every orange that we can
        //check if we have max value somewhere


        return maxTime(time);

    }

    int maxTime(int[][] time){
        int maxTime = Integer.MIN_VALUE;
        for(int[] arr: time){
            for(int t: arr){
                if(t==Integer.MAX_VALUE){
                    return -1;
                }

                maxTime = Math.max(t, maxTime);
            }
        }
        return maxTime;
    }

    boolean isValid(int x, int y, int n, int m, boolean[][] visited, int[][] A){
        if(x<0 || y<0 || x>=n || y>=m || visited[x][y] || A[x][y]!=1){
            return false;
        }
        return true;
    }
}
