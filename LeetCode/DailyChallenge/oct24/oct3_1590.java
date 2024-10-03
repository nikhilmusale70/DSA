package DailyChallenge.oct24;

import java.util.HashMap;

public class oct3_1590 {
    public static void main(String[] args) {
        int[] nums = {6,3,5,2};
        int p = 9;
        oct3_1590 obj = new oct3_1590();
        System.out.println(obj.minSubarray(nums, p));
    }

    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }
        if (totalSum == 0) return 0;

        int sumWeWant = totalSum % p;
        HashMap<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1); // To handle cases where we find the sum directly from the start

        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum = (currentSum + nums[i]) % p;
            int targetRemainder = (currentSum - sumWeWant + p) % p;

            // Check if there's a prefix sum with the remainder we want to remove
            if (remainderIndexMap.containsKey(targetRemainder)) {
                int subarrayLength = i - remainderIndexMap.get(targetRemainder);
                minLength = Math.min(minLength, subarrayLength);
            }

            // Store the current remainder and its index
            remainderIndexMap.put(currentSum, i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
