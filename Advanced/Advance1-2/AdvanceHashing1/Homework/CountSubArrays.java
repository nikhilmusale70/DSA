package AdvanceHashing1.Homework;

import java.sql.SQLOutput;
import java.util.HashSet;

/*
* Problem Description

Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.

Since the number of subarrays could be large, return value % 109 +7.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 106



Input Format

The only argument given is an Array A, having N integers.



Output Format

Return the number of subarrays of A, that have unique elements.



Example Input

Input 1:

 A = [1, 1, 3]
Input 2:

 A = [2, 1, 2]


Example Output

Output 1:

 4
Output 1:

 5


Example Explanation

Explanation 1:

 Subarrays of A that have unique elements only:
 [1], [1], [1, 3], [3]
Explanation 2:

 Subarrays of A that have unique elements only:
 [2], [1], [2, 1], [1, 2], [2]*/
public class CountSubArrays {
    public static void main(String[] args) {
        int[] A = { 1,1,2};
        CountSubArrays obj = new CountSubArrays();
        System.out.println(obj.solve(A));
    }
    //count unique elements subarrays
    public int solve(int[] A) {
        long ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        int i=0, j=0;

        while (j<A.length){
            if(hs.contains(A[j])){
                hs.remove(A[i]);
                i++;
            }
            else {
                hs.add(A[j]);
                ans += j-i+1;
                j++;
            }
        }

        return (int) ans%1000000007;
    }
}
