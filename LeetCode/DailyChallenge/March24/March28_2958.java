package DailyChallenge.March24;

import java.util.HashMap;
import java.util.Map;

public class March28_2958 {
    public static void main(String[] args) {
        March28_2958 obj = new March28_2958();
        int[] nums = {1,2,3,1,2,3,1,2}; int k = 2;
        System.out.println(obj.maxSubarrayLength(nums, k));
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int maxLength  = 0, start = -1;
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int end = 0; end < nums.length; end++) {
            frequency.put(nums[end], frequency.getOrDefault(nums[end], 0) + 1);
            while (frequency.get(nums[end]) > k) {
                start++;
                frequency.put(nums[start], frequency.get(nums[start]) - 1);
            }
            maxLength  = Math.max(maxLength , end - start);
        }

        return maxLength ;
    }
}
