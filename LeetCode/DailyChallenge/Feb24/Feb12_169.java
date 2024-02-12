package DailyChallenge.Feb24;

public class Feb12_169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        Feb12_169 obj = new Feb12_169();
        System.out.println(obj.majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int count = 0;

        for(int num: nums){
            if(count==0){
                ele = num;
            }
            if(ele == num){
                count++;
            }
            else{
                count--;
            }
        }
        return ele;
    }
}
