package HashMap;

import Utils.ScaUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q1FindValue {
    /*
    * Problem Description
Given an array A. You have some queries given by the array B.

For the i-th query, find the frequency of B[i] in the array A.



Problem Constraints
1 <= |A| <= 105

1 <= |B| <= 105

1 <= A[i] <= 105

1 <= B[i] <= 105



Input Format
First argument A is an array of integers.

Second argument B is an array of integers denoting the queries.



Output Format
Return an array of integers answering each of the queries.



Example Input
Input 1:
A = [1, 2, 1, 1]
B = [1, 2]
Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]


Example Output
Output 1:
[3, 1]
Output 2:
[0, 2]


Example Explanation
For Input 1:
The frequency of 1 in the array A is 3.
The frequency of 2 in the array A is 1.
For Input 2:
The frequency of 3 in the array A is 0.
The frequency of 2 in the array A is 2.

    * */

    public static void main(String[] args) {
        int[] arr = {7, 6, 6, 3, 1, 5, 7 };
        int[] arr2 = {2, 1, 7, 5, 8};
        ArrayList<Integer> arrLis = ScaUtils.arrToArrayList(arr);
        ArrayList<Integer> arrLis2 = ScaUtils.arrToArrayList(arr2);

        System.out.println(solve(arrLis, arrLis2));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<A.size(); i++) {
            if (hm.containsKey(A.get(i))){
                hm.put(A.get(i), (hm.get(A.get(i))+1));

            }
            else{
                hm.put(A.get(i), 1);
            }
        }

        for(int i=0; i<B.size(); i++){
            if (hm.containsKey(B.get(i))){
                B.set(i, hm.get(B.get(i)));
            }
            else{
                B.set(i, 0);
            }

        }
        return B;
    }
}
