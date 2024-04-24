package DailyChallenge.April24;

import java.util.Arrays;

public class April24_1137 {
    public static void main(String[] args) {
        int n =4;
        April24_1137 obj = new April24_1137();
        System.out.println(obj.tribonacci(n));
    }
    int[] dp;
    public int tribonacci(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n);
    }
    int helper(int n){
        if(n==2 || n==1)return 1;
        if(n==0) return 0;

        if(dp[n]!=-1) return dp[n];

        return dp[n] = helper(n-3)+helper(n-2)+helper(n-1);
    }
}
