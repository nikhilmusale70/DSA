package DailyChallenge.May24;

public class May20_1863 {
    public static void main(String[] args) {
        int[] nums = {5,1,6};
        May20_1863 obj = new May20_1863();
        System.out.println(obj.subsetXORSum(nums));
    }
    public int subsetXORSum(int[] nums) {
        int result = 0;
        for(int num: nums){
            result |= num;
        }
        return (int)(result * (Math.pow(2, nums.length-1)));
    }
}
