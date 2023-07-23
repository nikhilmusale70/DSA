//Q. longest subarray sum should be 0
/*
* Problem Description
Given an array A of N integers.

Find the length of the longest subarray in the array which sums to zero.


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -2, 1, 2]
Input 2:

 A = [3, 2, -1]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 [1, -2, 1] is the largest subarray which sums up to 0.
Explanation 2:

 No subarray sums up to 0.

* */

package Hashing2;

import Utils.ScaUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubarraySum0 {
    public static void main(String[] args) {

        int[] arr = {9, -20, -11, -8, -4, 2, -12, 14, 1};
        ArrayList<Integer> arrLis = ScaUtils.arrToArrayList(arr);
        System.out.println(solve(arrLis));
    }

    public static int solve(ArrayList<Integer> A){
            int len=Integer.MIN_VALUE, temp;
            HashMap<Long, Long> hm = new HashMap<>();
            Long[] pfArr = new Long[A.size()];

            pfArr[0] = Long.valueOf(A.get(0));
            hm.put(pfArr[0], 0L);

            for(int i=1; i<A.size(); i++){
                pfArr[i] = A.get(i) + pfArr[i-1];
                if(hm.containsKey(pfArr[i]) || pfArr[i]==0){
                    if(pfArr[i]==0){
                        len = Math.max(len, i);
                    }
                    else {
                        temp = (int) (i - hm.get(pfArr[i]) -1);
                        len = Math.max(len, temp);
                        System.out.println(len);
                    }
                }
                else {
                    hm.put(pfArr[i], (long) i);
                }
                System.out.println("HashMap for I: "+i+ " : " + hm);
            }

            if(len==Integer.MIN_VALUE){
                return 0;
            }

            return len+1;
    }
}
