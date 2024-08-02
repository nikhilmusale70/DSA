package DailyChallenge.Aug24;

import java.util.Arrays;

public class Aug2_2134 {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,0,1,1,0};
        Aug2_2134 obj = new Aug2_2134();
        System.out.println(obj.minSwaps(nums));
    }
    public int minSwaps(int[] nums) {
        int[] arr = new int[nums.length+nums.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = nums[i%nums.length];
        }

        //calculate number of ones
        int windowSize = (int) Arrays.stream(nums)
                        .filter(num -> num == 1)
                        .count();
        //window size would be numOfOnes
        int maxCount1=0;
        int currOne = 0;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                currOne++;
            }
            if (i >= windowSize && arr[i - windowSize] == 1) {
                currOne--;
            }
            maxCount1 = Math.max(maxCount1, currOne);
        }
        return windowSize-maxCount1;
    }
}
