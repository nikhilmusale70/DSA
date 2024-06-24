package DailyChallenge.June24;

import javax.swing.plaf.IconUIResource;

public class June23_995 {
    public static void main(String[] args) {
        June23_995 obj = new June23_995();
        int[] nums = {0,0,0,1,0,1,1,0};
        int k = 3;
        System.out.println(obj.minKBitFlips(nums, k));
    }
    public int minKBitFlips(int[] nums, int k) {
        int ans = 0;
        int i;
        for(i=0; i<=nums.length-k; i++){
            if(nums[i]==0){
                int counter=0;
                while (counter<k){
                    nums[i+counter] = nums[i+counter]==1?0:1;
                    counter++;
                }
                ans++;
            }
        }
        for(;i<nums.length; i++){
            if (nums[i]==0) return -1;
        }
        return ans;
    }
}
