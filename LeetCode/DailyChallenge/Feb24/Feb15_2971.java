package DailyChallenge.Feb24;

import java.util.Arrays;

public class Feb15_2971 {
    public static void main(String[] args) {
        Feb15_2971 obj = new Feb15_2971();
        int[] nums = {1,1,2,3,5,12,50};
        System.out.println(obj.largestPerimeter(nums));
    }
    public long largestPerimeter(int[] nums) {
        // Check if the array has less than 2 elements, return -1 since it's not possible to form a triangle
        if(nums.length < 2)
            return -1;

        // Sort the array in ascending order
        Arrays.sort(nums);

        // Initialize a variable to store the sum of all elements in the array
        long sum = 0;
        for(int num : nums)
            sum += num;

        // Iterate through the sorted array from the end
        for(int i = nums.length - 1; i >= 2; i--) {
            // Check if sum of two smaller sides is greater than the largest side
            if(sum - nums[i] > nums[i])
                // If so, return the sum of the sides as the largest perimeter
                return sum;

            // If the condition above is not met, subtract the largest side from the sum
            sum -= nums[i];
        }

        // If no valid triangle is found, return -1
        return -1;
    }

}
