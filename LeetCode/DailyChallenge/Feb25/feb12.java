package DailyChallenge.Feb25;

import java.util.HashMap;

public class feb12 {
    public static void main(String[] args) {
        int[] nums = {383, 77, 97, 261, 102, 344, 150, 130, 55, 337, 401, 498, 21, 5};
        feb12 obj = new feb12();
        System.out.println(obj.maximumSum(nums));
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = -1;
        for(int i=0; i<nums.length; i++){
            int numSum = getNumSum(nums[i]);
            if(hm.containsKey(numSum)){
                int sum = nums[i] + hm.get(numSum);
                ans = Math.max(ans, sum);
                if(nums[i]>hm.get(numSum)){
                    //replace
                    hm.replace(numSum, nums[i]);
                }
            }
            else{
                hm.put(numSum, nums[i]);
            }
        }
        return ans;
    }

    int getNumSum(int num) {
        int ans = 0;
        for (char digit : String.valueOf(num).toCharArray()) {
            ans += digit - '0';
        }
        return ans;
    }
}
