package DailyChallenge.March24;

import java.util.Arrays;

public class March15_238 {
    public static void main(String[] args) {
        int []nums = {1,2,3,4};
        March15_238 obj = new March15_238();
        System.out.println(Arrays.toString(obj.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];

        int pfProduct = 1;
        for(int i=0; i<nums.length; i++){
            products[i] = pfProduct;
            pfProduct *= nums[i];
        }

        int suffixProduct = 1;
        for(int i=nums.length-1; i>=0; i--){
            products[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return products;
    }
}
