package DailyChallenge.Feb24;

public class Feb20_268 {
    public static void main(String[] args) {
        int[] nums = {0,1,3};
        Feb20_268 obj = new Feb20_268();
        System.out.println(obj.missingNumber(nums));
    }
    public int missingNumber(int[] nums) {
        // Initialize the answer variable to 0.
        int ans = 0;

        // Iterate through the array.
        for(int i = 0; i < nums.length; i++) {
            // XOR operation between current index and element.
            // This effectively cancels out the numbers that are present in the array,
            // leaving only the missing number in the end.
            ans ^= (i ^ nums[i]);
        }

        // After the loop, the 'ans' variable will hold the XOR of the missing number
        // and the length of the array. XORing it with the length will give us the missing number.
        return ans ^ nums.length;
    }

}
