import java.util.Arrays;

public class Nov17_1877 {
    public static void main(String[] args) {
        int[] nums = {3,5,4,2,4,6};
        Nov17_1877 obj = new Nov17_1877();
        System.out.println(obj.minPairSum(nums));
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        //let start forming pair
        int left =0;
        int right=nums.length-1;
        int ans = 0;
        while(left<right){
            int pairSum = nums[left] + nums[right];
            ans = Math.max(ans, pairSum);
            left++;
            right--;
        }
        return ans;
    }
}
