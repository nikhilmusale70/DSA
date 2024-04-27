package DailyChallenge.April24;

import java.util.Arrays;

public class April26_1289 {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        April26_1289 obj = new April26_1289();
        System.out.println(obj.minFallingPathSum(grid));
    }
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < grid.length; col++) {
            answer = Math.min(answer, helper(0, col, grid, dp));
        }

        return answer;
    }
    int helper(int row, int col, int[][] grid, int[][] dp){
        if(row==grid.length-1){
            return grid[row][col];
        }
        if (dp[row][col]!=-1) return dp[row][col];

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<grid[0].length; i++){
            if(i!=col){
                ans = Math.min(ans, helper(row+1, i, grid, dp));
            }
        }

        return dp[row][col] = ans+grid[row][col];
    }
}
