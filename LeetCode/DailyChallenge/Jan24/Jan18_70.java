package DailyChallenge.Jan24;

public class Jan18_70 {
    public static void main(String[] args) {
        int n=4;
        Jan18_70 obj = new Jan18_70();
        System.out.println(obj.climbStairs(n));
    }

    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        return helper(n);
    }
    int helper(int n){
        if(n<2) return 1;
        if(dp[n]!=0) return dp[n];
        return dp[n] = helper(n-1)+helper(n-2);
    }
}
