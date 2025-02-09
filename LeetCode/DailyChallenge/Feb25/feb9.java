package DailyChallenge.Feb25;

import java.util.HashMap;

public class feb9 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        feb9 obj = new feb9();
        System.out.println(obj.countBadPairs(nums));
    }

    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int goodPairs=0;
        for(int i=0; i<nums.length; i++){
            int diff = i-nums[i];
            if(freq.containsKey(diff)){
                goodPairs+=freq.get(diff);
            }
            freq.put(diff, freq.getOrDefault(diff, 0)+1);
        }
        int n = nums.length;
        int totalPairs = n*(n-1)/2;
        return totalPairs-goodPairs;
    }
}
