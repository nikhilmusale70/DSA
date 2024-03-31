package DailyChallenge.March24;

import java.util.HashMap;

public class March30_992 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        March30_992 obj = new March30_992();
        System.out.println(obj.subarraysWithKDistinct(nums, k));
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int one = slidingWindowAtMost(nums, k);
        int two = slidingWindowAtMost(nums, k - 1);
        return  one- two ;
    }

    public int slidingWindowAtMost(int[] nums, int k){
        int start = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;

        for (int end=0; end<nums.length; end++) {
            hm.put(nums[end], hm.getOrDefault(nums[end], 0) + 1);
            while (hm.size() > k) {
                //start popping out
                hm.put(nums[start], hm.get(nums[start]) - 1);
                if (hm.get(nums[start]) == 0) hm.remove(nums[start]);
                start++;
            }
            ans += end - start + 1;
        }
        return ans;
    }
}
