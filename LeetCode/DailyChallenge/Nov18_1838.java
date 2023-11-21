package DailyChallenge;

import java.util.Arrays;

public class Nov18_1838 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,4};
        int k = 2;

        Nov18_1838 obj = new Nov18_1838();
        System.out.println(obj.maxFrequency(arr, k));
    }
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left=0, right=0;
        int total = 0;
        int ans = 0;

        while(right<nums.length){
            total += nums[right];

            while(nums[right] * (right - left  + 1) > total + k){
                total -= nums[left];
                left++;
            }

            ans = Math.max(ans, (right - left  + 1));
            right++;
        }

        return ans;
    }
}
