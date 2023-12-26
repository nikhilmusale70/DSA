package DailyChallenge.Dec23;

import java.util.ArrayList;
import java.util.Arrays;

public class Dec25_91 {
    public static void main(String[] args) {
        String str = "225";
        Dec25_91 obj = new Dec25_91();
        System.out.println(obj.numDecodings(str));
        System.out.println(obj.numDecodingsFor(str));
    }
    public int numDecodingsFor(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; // empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
    public int numDecodings(String s) {
        int prev2 = 1;
        int prev1 = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < s.length() + 1; i++) {
            int curr = 0;
            if (s.charAt(i - 1) != '0') {
                curr += prev1;
            }
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                curr += prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
