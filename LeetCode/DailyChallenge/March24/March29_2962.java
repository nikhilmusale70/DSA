package DailyChallenge.March24;

import java.util.Arrays;

public class March29_2962 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        int k = 2;
        March29_2962 obj = new March29_2962();
        System.out.println(obj.countSubarrays(nums, k));
    }
    public long countSubarrays(int[] nums, int k) {
        // Find the maximum element in the array
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Initialize variables for sliding window approach
        int start = 0; // Start index of the window
        int elementInWindow = 0; // Count of elements in the window that are equal to the maximum value
        long ans = 0; // Count of subarrays satisfying the condition

        // Loop through the elements of the array
        for (int num : nums) {
            // If the current element is equal to the maximum element, increment elementInWindow count
            if (num == max)
                elementInWindow++;

            // Slide the window until the count of elements in the window equals k
            while (elementInWindow == k) {
                // If the element at the start of the window is equal to the maximum value, decrement elementInWindow count
                if (nums[start] == max)
                    elementInWindow--;
                // Move the start of the window forward
                start++;
            }

            // Add the count of valid subarrays to the answer
            ans += start;
        }
        // Return the total count of valid subarrays
        return ans;
    }

}
