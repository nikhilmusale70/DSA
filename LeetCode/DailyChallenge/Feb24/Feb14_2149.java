package DailyChallenge.Feb24;

import java.util.Arrays;

public class Feb14_2149 {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        Feb14_2149 obj = new Feb14_2149();
        System.out.println(Arrays.toString(obj.rearrangeArray(nums)));
    }

    public int[] rearrangeArray(int[] nums) {
        // Initialize pointers for positive (p) and negative (n) elements
        int p = 0, n = 1;
        // Initialize a new array to store the rearranged elements
        int[] ans = new int[nums.length];

        // Iterate through the input array
        for (int num : nums) {
            // If the current number is positive, place it at even indices
            if (num > 0) {
                ans[p] = num; // Place positive number at even index
                p += 2; // Increment the pointer for positive numbers
            } else { // If the current number is negative, place it at odd indices
                ans[n] = num; // Place negative number at odd index
                n += 2; // Increment the pointer for negative numbers
            }
        }
        // Return the rearranged array
        return ans;
    }
}
