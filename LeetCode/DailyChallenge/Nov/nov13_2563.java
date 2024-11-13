package DailyChallenge.Nov;

import java.util.Arrays;

public class nov13_2563 {
    public static void main(String[] args) {
        int[] nums = {0,1,7,4,4,5};
        int lower = 3, upper = 6;
        nov13_2563 obj = new nov13_2563();
        System.out.println(obj.countFairPairs(nums, lower, upper));
    }

    //0 1 4 4 5 7
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int pairsLessThanUpper = numOfPairsLessThanValue(nums, upper);
        int pairsLessThanLower = numOfPairsLessThanValue(nums, lower);
        return pairsLessThanUpper - pairsLessThanLower;
    }
    int numOfPairsLessThanValue(int[] nums, int value){
        int left = 0, right = nums.length-1;
        int ans = 0;
        while (left<right) {
            int sum = nums[left] + nums[right];
            if (sum > value) {
                right--;
            }
            else{
                ans += right - left;
                left++;
            }
        }
        return ans;
    }
}
