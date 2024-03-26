package DailyChallenge.March24;

public class March24_287 {
    public int findDuplicate(int[] nums) {
        // Initialize two pointers, slow and fast, both starting at the first element of the array
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detecting the intersection point in the cycle
        // Using Floyd's Tortoise and Hare algorithm to find the intersection point
        // where slow and fast pointers meet within the cycle
        do {
            // Move slow pointer one step ahead
            slow = nums[slow];
            // Move fast pointer two steps ahead
            fast = nums[nums[fast]];
        } while (slow != fast); // Repeat until slow and fast pointers meet

        // Phase 2: Finding the starting point of the cycle
        // Reset fast pointer to the first element of the array
        fast = nums[0];
        // Move both slow and fast pointers one step at a time until they meet
        while (slow != fast) {
            // Move slow pointer one step ahead
            slow = nums[slow];
            // Move fast pointer one step ahead
            fast = nums[fast];
        }
        // Return the duplicate element found at the intersection point
        return fast;
    }
}

