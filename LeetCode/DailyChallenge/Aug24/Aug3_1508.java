package DailyChallenge.Aug24;

import java.util.Arrays;

public class Aug3_1508 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int n = 4, left = 1, right = 5;
        Aug3_1508 obj =  new Aug3_1508();
        System.out.println(obj.rangeSum(nums, n, left, right));
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        int ans = 0;
        int idx = 0;
        int[] newArr = new int[n*(n+1)/2];
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                newArr[idx] = sum;
                idx++;
            }
        }
        Arrays.sort(newArr);
        left--;
        int mod = (int) 1e9+7;
        while(left<right){
            ans = (ans + newArr[left++]) %mod;
        }
        return ans;
    }
}
