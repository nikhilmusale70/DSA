package DailyChallenge.June24;

public class June22_1248 {
    public static void main(String[] args) {
        June22_1248 obj = new June22_1248();
        int[] nums = {1,1,1,2,2,1,1};
        int k = 3;
        System.out.println(obj.numberOfSubarrays(nums, k));
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int totalSubarrays = 0;
        int countOddNumbers = 0;
        int evenPrefixCount = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] % 2 == 1) {
                countOddNumbers++;
            }

            if (countOddNumbers == k) {
                evenPrefixCount = 0;

                while (countOddNumbers == k) {
                    countOddNumbers -= nums[start] % 2;
                    evenPrefixCount++;
                    start++;
                }
            }
            totalSubarrays += evenPrefixCount;
        }

        return totalSubarrays;
    }
}
