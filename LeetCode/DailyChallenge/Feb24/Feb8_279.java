package DailyChallenge.Feb24;

import java.util.Arrays;

public class Feb8_279 {
    public static void main(String[] args) {
        Feb8_279 obj = new Feb8_279();
        System.out.println(obj.numSquares(12));
    }

    int[] memo;

    public int numSquares(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return solve(n);
    }

    public int solve(int n) {
        if(n == 0) return 0;
        if(n < 0) return Integer.MAX_VALUE;
//        if(memo[n] != -1) return memo[n];
        int ans = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++) {
            ans = Math.min(ans,1 + solve(n-(i*i)));
        }
        return ans;
//        return memo[n] = ans;
    }
}
