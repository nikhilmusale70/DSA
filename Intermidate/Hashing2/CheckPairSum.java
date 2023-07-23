/*Problem Description
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.


Problem Constraints
1<= Length of array B <= 103
0<= Bi <=109
0<= A <=109


Input Format
First argument A is the Target sum, and second argument is the array B


Output Format
Return an integer value 1 if there exists such pair, else return 0.


Example Input
Input 1:

A = 8   B = [3, 5, 1, 2, 1, 2]
Input 2:

A = 21   B = [9, 10, 7, 10, 9, 1, 5, 1, 5]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
In Example 1:
It is possible to obtain sum 8 using 3 and 5.
*/
package Hashing2;

import Utils.ScaUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CheckPairSum {
    public static void main(String[] args) {
        int[] arr = {85, 1, 43, 57, 16, 68, 15, 1, 0, 51};
        ArrayList<Integer> arrLis = ScaUtils.arrToArrayList(arr);
        int k=0;
        System.out.println(solve(k, arrLis));

    }

    public static int solve(int A, ArrayList<Integer> B) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0; i<B.size(); i++){
            if(hs.contains(A-B.get(i))){
                return 1;
            }
            hs.add(B.get(i));
        }
        return 0;
    }
}
