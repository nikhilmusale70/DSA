package DailyChallenge.June24;

import java.util.Arrays;

public class June12_75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        June12_75 obj = new June12_75();
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        int low=0, mid=0, high = nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++; mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
