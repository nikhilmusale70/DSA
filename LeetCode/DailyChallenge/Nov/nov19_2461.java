package DailyChallenge.Nov;

import java.util.HashMap;
import java.util.Map;

public class nov19_2461 {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        nov19_2461 obj = new nov19_2461();
        System.out.println(obj.maximumSubarraySum(nums, k));
    }
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, windowSum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int duplicates = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add the current number to the window
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (countMap.get(nums[i]) == 2) duplicates++;
            windowSum += nums[i];

            // Remove the element that slides out of the window
            if (i >= k) {
                int toRemove = nums[i - k];
                if (countMap.get(toRemove) == 2) duplicates--;
                countMap.put(toRemove, countMap.get(toRemove) - 1);
                windowSum -= toRemove;
            }

            // Update maxSum if the window has no duplicates
            if (i >= k - 1 && duplicates == 0) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }
}
