package DailyChallenge.oct24;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class oct10_962 {
    public static void main(String[] args) {
        int[] A = {9,8,1,0,1,9,4,0,4,1};
        oct10_962 obj = new oct10_962();
        System.out.println(obj.maxWidthRamp(A));
    }
    public int maxWidthRamp(int[] nums) {
        int[] maxArr = getMaxArr(nums);
        int l = 0;
        int ans = 0;

        for(int r=0; r<nums.length; r++){
            while(nums[l]>maxArr[r]){
                l++;
            }
            ans = Math.max(ans, r-l);
        }
        return ans;
    }

    int[] getMaxArr(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        ans[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            ans[i] = Math.max(nums[i], ans[i+1]);
        }
        return ans;
    }
}
