package DailyChallenge.March24;

import java.util.HashMap;

public class March16_525 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,0,1,1,0};
        March16_525 obj = new March16_525();
        System.out.println(obj.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        int count = 0;
        int maxCount = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) count -= 1;
            else count += 1;

            if(hm.containsKey(count)){
                maxCount = Math.max(maxCount, i-hm.get(count));
            }
            else{
                hm.put(count, i);
            }
        }
        return maxCount;
    }
}
