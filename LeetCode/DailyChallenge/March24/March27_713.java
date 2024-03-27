package DailyChallenge.March24;

public class March27_713 {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        March27_713 obj = new March27_713();
        System.out.println(obj.numSubarrayProductLessThanK(nums, 100));
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int sum = 1; // Initialize the product of elements in the window
        int result = 0; // Initialize the count of subarrays satisfying the condition
        int left = 0; // Initialize the left boundary of the window

        // Iterate through the array
        for (int right = 0; right < nums.length; right++) {
            sum *= nums[right]; // Include the current element in the product

            // Shrink the window from the left if product exceeds or equals k
            while (sum >= k && left <= right) {
                sum /= nums[left]; // Exclude the element at the left boundary
                left++; // Move the left boundary to the right
            }

            // Count the number of subarrays satisfying the condition and update the result
            result += right - left + 1;
        }

        return result; // Return the total count of subarrays satisfying the condition
    }

}
