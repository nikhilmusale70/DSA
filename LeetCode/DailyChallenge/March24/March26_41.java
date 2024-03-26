package DailyChallenge.March24;

public class March26_41 {
    public static void main(String[] args) {
        int[] nums= {3,4,-1,1};
        March26_41 obj = new March26_41();
        System.out.println(obj.firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int idx = nums[i] - 1;
            if (idx >= 0 && idx < nums.length && nums[i] != nums[idx]) {
                // Swap
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (index != nums[index] - 1) {
                return index + 1;
            }
        }
        return nums.length + 1;
    }

}
