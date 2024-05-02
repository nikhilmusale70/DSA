package DailyChallenge.May24;

import java.util.HashSet;

public class May2_2441 {
    public static void main(String[] args) {
        int[] nums ={-1,10,6,7,-7,1};
        May2_2441 obj = new May2_2441();
        System.out.println(obj.findMaxK(nums));
    }
    public int findMaxK(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int ans = -1;
        for(int num: nums){
            if(hs.contains(num*-1)){
                ans = Math.max(ans, Math.abs(num));
            }
            else{
                hs.add(num);
            }
        }
        return ans;
    }
}
