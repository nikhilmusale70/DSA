package AdvanceDsa_Arrays1;

import adv12Utils.ScaUtils;

import java.util.List;

public class MaxSumInArray {
    public static void main(String[] args) {
//        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] A = {-2, -1, -3, -4, -1, 2, -1, -5, -4};
        List<Integer> Alis = ScaUtils.arrToArrayList(A);
        System.out.println(maxSubArray(Alis));
    }
    public static int maxSubArray(final List<Integer> A) {
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;

        for(int i=0; i<A.size(); i++){
            tempSum += A.get(i);

            maxSum = Math.max(tempSum, maxSum);

            if(tempSum<=0) {
                tempSum = 0;
            }

        }

        return maxSum;
    }
}
