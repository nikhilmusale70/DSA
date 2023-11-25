package DailyChallenge.Nov23;

import java.util.Arrays;

public class Nov25_1685 {
    public static void main(String[] args) {
        Nov25_1685 obj = new Nov25_1685();
        int[] nums = {1,4,6,8,10};
        System.out.println(Arrays.toString(obj.getSumAbsoluteDifferences(nums)));
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum();
        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int toRight = nums.length-i-1;
            rightSum -= nums[i];

            int left = Math.abs(i *nums[i] - leftSum);
            int right = Math.abs(toRight*nums[i] - rightSum);
            ans[i] = left+right;

            leftSum+=nums[i];
        }
        return ans;
    }
}
