package DailyChallenge.April24;

import java.util.Arrays;

public class April27_514 {
    public static void main(String[] args) {
        String ring = "godding", key = "gd";
        April27_514 obj = new April27_514();
        System.out.println(obj.findRotateSteps(ring, key));
    }
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[105][105];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(ring, key, 0, 0, dp);
    }

    private int helper(String ring, String key, int idx1, int idx2, int[][] dp) {
        if (idx2 >= key.length()) return 0;
        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(idx2)) {
                int a = helper(ring, key, i, idx2 + 1, dp);
                ans = Math.min(ans, Math.min(Math.abs(idx1 - i), ring.length() - Math.abs(idx1 - i)) + 1 + a);
            }
        }
        return dp[idx1][idx2] = ans;
    }
}
