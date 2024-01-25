package DailyChallenge.Jan24;

import java.util.Arrays;

public class Jan25_1143 {
    public static void main(String[] args) {
        String  text1 = "abcde", text2 = "ace";
        Jan25_1143 obj = new Jan25_1143();
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return helper(text1, text2, text1.length()-1, text2.length()-1);
    }

    int helper(String t1, String t2, int idx1, int idx2){
        if(idx1==-1 || idx2==-1) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        int pick=0;
        if(t1.charAt(idx1) == t2.charAt(idx2)){
            pick = 1 + helper(t1, t2, idx1-1, idx2-1);
        }
        int dontPick = Math.max(helper(t1, t2, idx1-1, idx2), helper(t1, t2, idx1, idx2-1));

        return dp[idx1][idx2] = Math.max(pick, dontPick);
    }
}
