package DailyChallenge.Jan24;

import java.util.Arrays;

public class Jan26_576 {
    public static void main(String[] args) {
        Jan26_576 obj = new Jan26_576();
        System.out.println(obj.findPaths(2,2,2,0,0));
    }
    int[] row = {0,1,-1,0};
    int[] col = {1, 0, 0, -1};
    int[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m+1][n+1][maxMove+1];
        for(int[][] arr: dp) for(int[] ar: arr) Arrays.fill(ar, -1);

        return helper(startRow, startColumn, m, n, maxMove);
    }

    int mod = (int)1e9+7;
    int helper(int x, int y, int m, int n, int moves){
        if(!checkIfValid(x,y,m,n)){
            return 1;
        }
        if(moves<=0) return 0;

        if(dp[x][y][moves]!=-1) return dp[x][y][moves];

        int temp = 0;
        for(int i=0; i<4; i++){
            int newX = x + row[i];
            int newY = y + col[i];
            temp += helper(newX, newY, m, n, moves-1);
            temp %= mod;
        }
        return dp[x][y][moves] = temp%mod;
    }

    boolean checkIfValid(int x, int y, int m, int n){
        if(x>=m || y>=n || x<0 || y<0){
            return false;
        }
        return true;
    }
}
