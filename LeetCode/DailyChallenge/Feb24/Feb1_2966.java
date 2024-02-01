package DailyChallenge.Feb24;

import java.util.Arrays;

public class Feb1_2966 {
    public static void main(String[] args) {
        Feb1_2966 obj = new Feb1_2966();
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;

        System.out.println(Arrays.deepToString(obj.divideArray(nums, k)));
    }

    public int[][] divideArray(int[] nums, int k) {
        if(nums.length%3!=0){
            return new int[0][0];
        }

        Arrays.sort(nums);

        int[][] ans = new int[nums.length/3][3];
        int idx = 0;
        for(int row=0; row<ans.length; row++){
            for(int i=0; i<3; i++){
                ans[row][i] = nums[idx];
                idx++;
            }
            if(ans[row][2]-ans[row][0] > k){
                return new int[0][0];
            }
        }
        return ans;
    }
}
