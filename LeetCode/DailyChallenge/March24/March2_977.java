package DailyChallenge.March24;

import java.util.Arrays;

public class March2_977 {
    public static void main(String[] args) {
        int[] a = {4,10,9};
        March2_977 obj = new March2_977();
        System.out.println(Arrays.toString(obj.sortedSquares(a)));
    }
    public int[] sortedSquares(int[] nums) {
        int leftPointer = 0, rightPointer = nums.length - 1;
        int[] squaredResult = new int[nums.length];
        int resultIndex = nums.length - 1, squaredValue = 0;
        while (leftPointer <= rightPointer) {
            if (Math.abs(nums[leftPointer]) > Math.abs(nums[rightPointer])) {
                squaredValue = nums[leftPointer];
                leftPointer++;
            } else {
                squaredValue = nums[rightPointer];
                rightPointer--;
            }
            squaredResult[resultIndex] = squaredValue * squaredValue;
            resultIndex--;
        }
        return squaredResult;
    }
}
