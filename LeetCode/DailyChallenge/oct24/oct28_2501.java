package DailyChallenge.oct24;

import java.util.HashSet;
import java.util.Set;

public class oct28_2501 {
    public static void main(String[] args) {
        int[] nums= {4,3,6,16,8,2};
        oct28_2501 obj = new oct28_2501();
        System.out.println(obj.longestSquareStreak(nums));
    }
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for(int num: nums){
            set.add((long) num);
        }

        int streak = 1;
        for(long num: nums){
            int tempStreak = 1;
            while(set.contains(num*num)){
                tempStreak++;
                num = num * num;
            }
            streak = Math.max(streak, tempStreak);
        }
        return streak==1?-1:streak;
    }
}
