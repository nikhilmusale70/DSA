package DailyChallenge.Dec23;

import java.util.*;

public class Dec28_1531 {
    public static void main(String[] args) {
        Dec28_1531 obj = new Dec28_1531();
        String str = "aaabcccd";
        System.out.println(obj.getLengthOfOptimalCompression(str, 2));
    }
    private int[][] memo = new int[101][101];

    private int recursion(String s, int i, int K) {
        int n = s.length();
        int k = K;
        if (n - i <= k) {
            return 0;
        }
        if (memo[i][k] != -1) {
            return memo[i][k];
        }

        int ans = k > 0 ? recursion(s, i + 1, k - 1) : 101;
        int c = 1;
        for (int j = i + 1; j <= n; j++) {
            ans = Math.min(ans, 1 + ((c > 99) ? 3 : (c > 9) ? 2 : (c > 1) ? 1 : 0) + recursion(s, j, k));
            if (j < n && s.charAt(i) == s.charAt(j)) {
                c++;
            } else if (--k < 0) {
                break;
            }
        }
        return memo[i][K] = ans;
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return recursion(s, 0, k);
    }
}
