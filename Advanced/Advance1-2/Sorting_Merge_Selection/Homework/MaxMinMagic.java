package Sorting_Merge_Selection.Homework;

import java.util.Arrays;

public class MaxMinMagic {
    public static void main(String[] args) {
        int[] A = {-5, -1, 15, 12, 20, 1};
        MaxMinMagic obj = new MaxMinMagic();

        System.out.println(Arrays.toString(obj.solve(A)));
    }

    public int[] solve(int[] A) {
        long mod=1000000007;
        Arrays.sort(A);
        long maxDiff = 0;
        long minDiff = 0;

        for (int i=0; i<A.length/2; i++){
            maxDiff += Math.abs(A[i]-A[A.length-1-i])%mod;
            maxDiff %= mod;
        }

        for (int j=0; j<A.length; j+=2){
            minDiff += Math.abs(A[j]-A[j+1])%mod;
            maxDiff %= mod;
        }
        return new int[]{(int)maxDiff, (int)minDiff};
    }
}

