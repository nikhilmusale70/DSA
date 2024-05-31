package DailyChallenge.May24;

import java.util.Arrays;

public class May31_260 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        May31_260 obj = new May31_260();
        System.out.println(Arrays.toString(obj.singleNumber(nums)));
    }
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums) xor ^= num;
        int first = 0;

        int bit=0;
        for(; bit<32; bit++){
            int countOfOnes = 0;
            for(int num: nums){
                if (checkIfBitSet(num, bit)) countOfOnes++;
            }
            if(countOfOnes%2==1){
                break;
            }
        }
        for(int num: nums){
            if(checkIfBitSet(num, bit)){
                first ^= num;
            }
        }

        return new int[]{first, xor^first};
    }

    boolean checkIfBitSet(int num, int idx){
        return (num & (1 << idx)) != 0;
    }
}
