package DailyChallenge.April24;

public class April29_2997 {
    public static void main(String[] args) {
        April29_2997 obj = new April29_2997();
        int[] arr = {2,1,3,4};
        int k = 1;
        System.out.println(obj.minOperations(arr, k));
    }
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for(int num: nums){
            ans ^= num;
        }
        return getBitDifference(ans, k);
    }
    int getBitDifference(int num, int k){
        int ans = 0;
        for(int i=0; i<31; i++){
            if(checkBit(num, k, i)){
                ans++;
            }
        }
        return ans;
    }
    boolean checkBit(int num1, int num2, int idx){
        return (num1 & (1 << idx)) != (num2 & (1 << idx));
    }
}
