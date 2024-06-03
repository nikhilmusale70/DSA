package DailyChallenge.June24;

import java.util.Arrays;

public class June3_2486 {
    public static void main(String[] args) {
        June3_2486 obj = new June3_2486();

        String s = "coaching", t = "coding";
        System.out.println(obj.appendCharacters(s,t));
    }

    int[][] dp;
    public int appendCharacters(String s, String t) {
        dp = new int[s.length()+1][t.length()+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        int idx = helper(0, 0, s, t);
        return t.length()-idx;
    }

    int helper(int idxS, int idxT, String s, String t){
        if(idxS == s.length() || idxT == t.length()) return idxT;

        if(dp[idxS][idxT] != -1) return dp[idxS][idxT];
        //take
        int take = 0;
        if(t.charAt(idxT) == s.charAt(idxS)){
            take = helper(idxS+1, idxT+1, s, t);
        }
        int notTake = helper(idxS+1, idxT, s, t);

        return dp[idxS][idxT] = Math.max(take, notTake);
    }
}
