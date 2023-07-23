package HashMap;

import Utils.ScaUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Q3SubArrayWith0Sum {
    /*Problem Description
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

 The array has sum 0.
*/
    public static void main(String[] args) {
        int[] arr = {-7, -6, 6, 3, -1, -5, 7 };
        ArrayList<Integer> arrLis = ScaUtils.arrToArrayList(arr);

        System.out.println(solve(arrLis));
    }

    public static int solve(ArrayList<Integer> A) {
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
