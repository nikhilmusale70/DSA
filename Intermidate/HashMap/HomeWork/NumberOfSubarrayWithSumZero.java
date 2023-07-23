/*
Problem Description
Given an array A of N integers.

Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -1, -2, 2]
Input 2:

 A = [-1, 2, -1]


Example Output
Output 1:

3
Output 2:

1


Example Explanation
Explanation 1:

 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
Explanation 2:

 The subarray with zero sum is [-1, 2, -1].
 */

package HashMap.HomeWork;

import Utils.ScaUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NumberOfSubarrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {-7, -6, 6, 3, -1, -5, 7 };
        ArrayList<Integer> arrLis = ScaUtils.arrToArrayList(arr);

        System.out.println(subArrayWithSumZero(arrLis));
    }

//
//    public int solve(ArrayList<Integer> A) {
//
//    }

    public static int subArrayWithSumZero(ArrayList<Integer> A){
        long[] pfArr = new long[A.size()];
        HashSet<Long> hs = new HashSet<>();
        pfArr[0] = A.get(0);
        hs.add(pfArr[0]);

        for(int i=1; i<A.size(); i++){
            pfArr[i] = A.get(i) + pfArr[i-1];
            System.out.println(pfArr[i]);
            if(hs.contains(pfArr[i])){
                return 1;
            }
            hs.add(pfArr[i]);
        }
        return 0;
    }
}
