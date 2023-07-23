package AdvanceHashing1;

import java.util.HashMap;
import java.util.HashSet;

/*
* Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.*/
public class SubArrSum0 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, -4, 5};
        SubArrSum0 obj = new SubArrSum0();
        System.out.println(obj.solve(A));
    }

    public int solve(int[] A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        long[] pfSum = new long[A.length];
        pfSum[0] = A[0];

        HashSet<Long> hs = new HashSet<>();
        hs.add(pfSum[0]);
        for (int i=1; i<A.length; i++){
            pfSum[i] = A[i] + pfSum[i-1];
            if (hs.contains(pfSum[i]) || pfSum[i]==0)
                return 1;
            else
                hs.add(pfSum[i]);
        }
        return 0;
    }
}
