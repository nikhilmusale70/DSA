package DailyChallenge.Nov23;

import java.util.HashMap;

public class Nov21_1814 {
    public static void main(String[] args) {
        Nov21_1814 obj = new Nov21_1814();
        int[] nums = {1, 10};
        System.out.println(obj.countNicePairs(nums));
    }
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans=0;
        for(int num: nums){
            int reverse = reverseOf(num);
            int temp = hm.getOrDefault(num - reverse, 0);
            ans = (ans + temp)%mod;
            hm.put(num - reverse, temp+1);
        }
        return ans;
    }

    private int reverseOf(int num) {
        int ans=0;
        while(num>0){
            ans = ans*10 + num%10;
            num = num/10;
        }
        return ans;
    }
}
