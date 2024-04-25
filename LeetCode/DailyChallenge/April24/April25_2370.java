package DailyChallenge.April24;

import java.util.Arrays;

public class April25_2370 {
    public static void main(String[] args) {
        String s = "pvjcci"; int k = 4;
        April25_2370 obj = new April25_2370();
        System.out.println(obj.longestIdealString(s, k));
    }

    public int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length()+1][123];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return solveMemo(s, 0, k, '#', dp);
    }

    int solveMemo(String s, int idx, int k, char prev, int[][] dp){
        if(idx==s.length()) return 0;

        if(dp[idx][prev]!=-1) return dp[idx][prev];

        int take = 0;
        int dontTake = 0;

        if(prev=='#' || Math.abs(s.charAt(idx)-prev)<=k){
            take = 1 + solveMemo(s, idx+1, k, s.charAt(idx), dp);
        }
        dontTake = solveMemo(s, idx+1, k, prev, dp);

        return dp[idx][prev] = Math.max(take, dontTake);
    }
}
