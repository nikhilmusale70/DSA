package DailyChallenge.March24;

public class March31_2444 {
    public static void main(String[] args) {
        March31_2444 obj = new March31_2444();
        int[] nums = {1,3,5,2,7,5};
        int minK = 1, maxK = 5;
        System.out.println(obj.countSubarrays(nums, minK, maxK));
    }
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int badIdx = -1;
        int leftIdx = -1;
        int rightIdx = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                badIdx = i;
            }
            if (nums[i] == minK) {
                leftIdx = i;
            }
            if (nums[i] == maxK) {
                rightIdx = i;
            }
            res += Math.max(0, Math.min(leftIdx, rightIdx) - badIdx);
        }
        return res;
    }
}
