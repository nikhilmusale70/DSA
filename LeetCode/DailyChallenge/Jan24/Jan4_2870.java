package DailyChallenge.Jan24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Jan4_2870 {
    public static void main(String[] args) {
        Jan4_2870 obj = new Jan4_2870();
        System.out.println(obj.minOperations(new int[]{2,1,2,2,3,3}));
    }

    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            int count = 0;
            while(i<nums.length && curr==nums[i]){
                count++;
                i++;
            }
            if(count == 1) return -1;
            ans += (count+2)/3;
            i--;
        }
        return ans;
    }
}
