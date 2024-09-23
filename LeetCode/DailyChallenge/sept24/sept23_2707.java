package DailyChallenge.sept24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class sept23_2707 {
    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        sept23_2707 obj = new sept23_2707();
        System.out.println(obj.minExtraChar(s, dictionary));
    }
    Integer[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        dp = new Integer[s.length()];
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        return helper(0, s.length(), s, set);
    }

    int helper(int s, int e, String str, Set<String> dictionary){
        if(s==e) return 0;
        if(dp[s] != null) return dp[s];

        //skip the char
        int ans = 0;
        ans = helper(s+1, e, str, dictionary) + 1;

        for(int idx=s; idx<e; idx++){
            String strFormed = str.substring(s, idx+1);
            if(dictionary.contains(strFormed)){
                ans = Math.min(ans, helper(idx+1, e, str, dictionary));
            }
        }
        return dp[s] = ans;
    }
}
