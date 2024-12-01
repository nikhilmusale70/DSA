package DailyChallenge.Nov;

import java.util.Arrays;

public class nov16_3254 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,2,5};
        int k = 3;
        nov16_3254 obj = new nov16_3254();
        System.out.println(Arrays.toString(obj.resultsArray(nums, k)));
    }
    public int[] resultsArray(int[] nums, int k) {
        //do we have valid
        boolean flag = false;
        int[] ans = new int[nums.length-k+1];
        for(int i=0; i<nums.length-k+1; i++) {
            for (int j = i; j < i+k-1; j++) {
                if (nums[j] != nums[j+1]-1) {
                    flag = true;
                    break;
                }
            }
            ans[i] = flag?-1:nums[i+k-1];
            flag = false;
        }
        return ans;
    }
}
