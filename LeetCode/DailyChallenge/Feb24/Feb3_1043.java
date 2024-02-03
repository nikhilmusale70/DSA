package DailyChallenge.Feb24;

import java.util.Arrays;

public class Feb3_1043 {
    public static void main(String[] args) {
        Feb3_1043 obj = new Feb3_1043();
        int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
        int k = 4;
        System.out.println(obj.maxSumAfterPartitioning(arr, k));
    }
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return helper(arr, arr.length, k);
    }

    int helper(int[] arr, int idx, int k){
        if(idx==0){
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int currMax = 0, best=0;

        for(int i=1; i<=k && i<=idx; i++){
            currMax= Math.max(currMax, arr[idx - i]);
            best= Math.max(best, helper(arr, idx-i, k) + (currMax*i));
        }

        return dp[idx] = best;
    }
}
