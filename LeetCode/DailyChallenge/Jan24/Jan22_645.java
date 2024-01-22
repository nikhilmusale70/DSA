package DailyChallenge.Jan24;

import java.util.Arrays;

public class Jan22_645 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,4};
        Jan22_645 obj = new Jan22_645();
        System.out.println(Arrays.toString(obj.findErrorNums(arr)));
    }

    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length+1];
        for(int i: nums){
            arr[i]++;
        }
        int missing = 0;
        int repeat = 0;
        for(int curr=1; curr<arr.length; curr++){
            if(arr[curr]==2){
                repeat = curr;
            }
            if(arr[curr]==0){
                missing = curr;
            }
        }

        return new int[]{repeat, missing};
    }
}
