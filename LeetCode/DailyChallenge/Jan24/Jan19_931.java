package DailyChallenge.Jan24;

import java.util.Arrays;

public class Jan19_931 {
    public static void main(String[] args) {
        int[][] arr = {{2,1,3},{6,5,4},{7,8,9}};
        Jan19_931 obj = new Jan19_931();
        System.out.println(obj.minFallingPathSum(arr));
    }

    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int ans = (int)1e8;

        //memoization part
        dp = new int[matrix.length][matrix[0].length];
        for(int[] arr: dp){
            Arrays.fill(arr, -101);
        }
        //-101 as we have a constraint that number could be -100

        //take every node of first row, as initial node and try find shortest path
        for(int col=0; col<matrix[0].length; col++){
            ans = Math.min(ans, helper(matrix, 0, col));
        }
        return ans;
    }

    int helper(int[][] mat, int row, int col){
        if(row==mat.length-1){
            return mat[row][col];
        }
        if(dp[row][col]!=-101) return dp[row][col];

        int ans = (int)1e8;
        for(int y=-1; y<=1; y++){
            int newRow = row + 1;
            int newCol = col + y;
            if (checkCoords(mat.length, mat[0].length, newRow, newCol)) {
                ans = Math.min(ans, mat[row][col] + helper(mat, newRow, newCol));
            }
        }
        return dp[row][col] = ans;
    }

    boolean checkCoords(int m, int n, int x, int y){
        return x < m && y < n && x >= 0 && y >= 0;
    }
}
