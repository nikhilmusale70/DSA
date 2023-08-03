package Graph2.Homework;

import Utils.ScaUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* Distance of nearest cell
Solved
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is atleast one 1 is present in the matrix.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 1



Input Format
The first argument given is the integer matrix A.



Output Format
Return the matrix B.



Example Input
Input 1:

 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1]
       [0, 1, 1, 0]
     ]
Input 2:

 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]
     ]


Example Output
Output 1:

 [
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]
 ]
Output 2:

 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4]
 ]


Example Explanation
Explanation 1:

 A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 A[1][0], A[1][1] will be nearest to A[1][2].
 A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].
Explanation 2:

 There is only a single 1. Fill the distance from that 1.
 * */
public class DistanceOfNearestCell {
    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
        };
        ScaUtils.print2dArray(new DistanceOfNearestCell().solve(A));
    }
    class Pair{
        int x, y;
        Pair(int a, int b){
            x = a;
            y = b;
        }
    }
    public int[][] solve(int[][] A) {
        Queue<Pair> q = new LinkedList<>();
        int[][] time = new int[A.length][A[0].length];
        for(int[] arr: time){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(A[i][j]==1){
                    q.add(new Pair(i, j));
                    time[i][j]=0;
                }
            }
        }


        int[] cordX = {1,-1, 0,0};
        int[] cordY = {0,0, -1, 1};
        while(!q.isEmpty()){
            Pair elemToRemove = q.remove();
            for(int i=0; i<4; i++){
                int x = elemToRemove.x + cordX[i];
                int y = elemToRemove.y + cordY[i];

                if (isValid(x, y, A.length, A[0].length, time)){
                    q.add(new Pair(x, y));
                    time[x][y] = time[elemToRemove.x][elemToRemove.y] + 1;
                }
            }
        }
        return time;
    }

    boolean isValid(int x, int y, int bondX, int bondY, int[][] time){
        if(x<0 || y<0 || x>=bondX || y>=bondY || time[x][y]!=Integer.MAX_VALUE){
            return false;
        }
        return true;
    }
}
