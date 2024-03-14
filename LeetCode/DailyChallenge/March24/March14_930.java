package DailyChallenge.March24;

public class March14_930 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        March14_930 obj = new March14_930();
        System.out.println(obj.numSubarraysWithSum(nums, goal));
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0, count = 0, res = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] == 1) {
                goal--;
                count = 0;
            }

            while (goal == 0 && i <= j) {
                goal += nums[i];
                i++;
                count++;
                if (i > j - goal + 1)
                    break;
            }

            while (goal < 0) {
                goal += nums[i];
                i++;
            }

            res += count;
        }
        return res;
    }
}
