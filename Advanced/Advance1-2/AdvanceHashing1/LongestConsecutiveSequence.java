package AdvanceHashing1;

import java.util.Arrays;
import java.util.HashSet;

/*
*Problem Description
Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from array A.



Problem Constraints
1 <= N <= 106

-106 <= A[i] <= 106



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.



Example Input
Input 1:

A = [100, 4, 200, 1, 3, 2]
Input 2:

A = [2, 1]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:

 The set of consecutive elements will be [1, 2]. */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();

        int[] A = {100, 4, 200, 1, 3, 2};
        System.out.println(obj.longestConsecutive(A));
    }
    public int longestConsecutive(final int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0; i<A.length; i++){
            hs.add(A[i]);
        }
        int ans =0;
        for (int i=0; i<A.length; i++){
            if(!hs.contains(A[i]-1)){
                int j=A[i];
                int countOfConsecutives=0;
                while(hs.contains(j)) {
                    countOfConsecutives++;
                    j++;
                }
                ans = Math.max(ans, countOfConsecutives);
            }
        }

        return ans;
    }
}
