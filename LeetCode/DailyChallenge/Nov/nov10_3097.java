package DailyChallenge.Nov;

public class nov10_3097 {
    public static void main(String[] args) {
        int[] nums = {2,1,9,12};
        int k = 21;
        nov10_3097 obj = new nov10_3097();
        System.out.println(obj.minimumSubarrayLength(nums, k));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int l=0, r=0;
        int window = 0;
        int ans = Integer.MAX_VALUE;
        while(r<nums.length){
            if(window<k) {
                window |= nums[r];
                r++;
            }
            while(l<nums.length && window>=k){
                if(r-l==0) return 1;
                ans = Math.min(ans, r-l);
                window -= nums[l];
                l++;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
