package DailyChallenge.June24;

import javax.swing.plaf.IconUIResource;

public class June23_995 {
    public static void main(String[] args) {
        June23_995 obj = new June23_995();
        int[] nums = {0,0,0,1,0,1,1,0};
        int k = 3;
        System.out.println(obj.minKBitFlips(nums, k));
    }
    public int minKBitFlips(int[] nums, int k) {
        boolean[] flipped = new boolean[nums.length];
        int flipsInCurrWindow = 0;
        int flips = 0;

        for (int i = 0; i < nums.length; i++) {
            // Check if the window has moved past k elements
            if (i >= k) {
                if (flipped[i - k]) {
                    flipsInCurrWindow--;
                }
            }
            // Determine if the current bit needs to be flipped
            if (flipsInCurrWindow % 2 == nums[i]) {
                // Check if there are enough elements remaining to flip
                if (i + k > nums.length) {
                    return -1;
                }
                flipsInCurrWindow++;
                flipped[i] = true;
                flips++;
            }
        }
        return flips;
    }
}
