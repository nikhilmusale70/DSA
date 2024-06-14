package DailyChallenge.June24;

import java.util.HashSet;

public class June14_945 {
    public static void main(String[] args) {
        June14_945 obj = new June14_945();
        int[] nums = {3,2,1,2,1,7};
        System.out.println(obj.minIncrementForUnique(nums));
    }
    public int minIncrementForUnique(int[] nums) {
        int max = nums[0];
        for(int num: nums){
            max = Math.max(max, num);
        }

        int[] freq = new int[max+nums.length];
        for(int num: nums){
            freq[num]++;
        }
        int ans = 0;
        for(int i=0; i<freq.length; i++){
            if(freq[i]<=1) continue;

            int duplicates = freq[i]-1;
            freq[i+1] += duplicates;
            ans += duplicates;
        }
        return ans;
    }
}
