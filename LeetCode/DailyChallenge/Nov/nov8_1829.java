package DailyChallenge.Nov;

import java.util.Arrays;

public class nov8_1829 {
    public static void main(String[] args) {
        int[] nums = {0,1,1,3};
        int maximumBit = 2;
        nov8_1829 obj = new nov8_1829();
        System.out.println(Arrays.toString(obj.getMaximumXor(nums, maximumBit)));
    }
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] ans = new int[nums.length];
        int maxVal = (int) (Math.pow(2, maximumBit)-1);

        int xor = 0;
        for(int num: nums) xor ^= num;

        for(int i=0; i<nums.length; i++){
            ans[i] = findMaxK(maximumBit, xor);
            xor = xor ^ nums[nums.length - i - 1];
        }
        return ans;
    }

    int findMaxK(int maxBit, int num){
        int ans = 0;
        for(int i=0; i<31; i++){
            if( (num&(1<<i)) == 0){
                if(i>=maxBit) break;
                ans = ans | 1<<i;
            }
        }
        return ans;
    }
}
