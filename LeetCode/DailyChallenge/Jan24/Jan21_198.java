package DailyChallenge.Jan24;

import java.util.Arrays;

public class Jan21_198 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        Jan21_198 obj = new Jan21_198();
        System.out.println(obj.rob(arr));
    }

    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return helper(nums, nums.length-1);
    }

    int helper(int[] nums, int idx){
        if(idx==1){
            return Math.max(nums[0], nums[1]);
        }
        if(idx==0) return nums[0];

        if(dp[idx]!=-1) return dp[idx];

        int steal = nums[idx] + helper(nums, idx-2);
        int dontSteal = helper(nums, idx-1);

        return dp[idx] = Math.max(steal, dontSteal);
    }
}
