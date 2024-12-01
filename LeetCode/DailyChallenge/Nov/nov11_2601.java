package DailyChallenge.Nov;

import java.util.Arrays;

public class nov11_2601 {
    public static void main(String[] args) {
        int[] nums = {15,20,17,7,16};
        nov11_2601 obj = new nov11_2601();
        System.out.println(obj.primeSubOperation(nums));
    }

    boolean[] primeNumber;
    public boolean primeSubOperation(int[] nums) {
        primeNumber = soe();
        for(int i=nums.length-1; i>0; i--){
            if(nums[i-1]>=nums[i]){
                int newNum = makeNumberSmaller(nums[i-1], nums[i]);
                if(newNum==-1) return false;
                nums[i-1] -= newNum;
            }
        }
        return true;
    }

    int makeNumberSmaller(int number, int high){
        for(int i=number-high; i<number; i++){
            if(primeNumber[i]){
                if(number-i<high){
                    return i;
                }
            }
        }
        return -1;
    }

    boolean[] soe(){
        boolean[] arr = new boolean[1000];
        Arrays.fill(arr, true);
        arr[0] = false; arr[1] = false;
        for(int i=2; i<arr.length; i++){
            if(arr[i]) {
                for (int j = i + i; j < arr.length; j += i) {
                    arr[j] = false;
                }
            }
        }
        return arr;
    }
}
