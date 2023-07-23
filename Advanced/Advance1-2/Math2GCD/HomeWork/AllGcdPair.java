package Math2GCD.HomeWork;

import adv12Utils.ScaUtils;

import java.util.*;

/*
* Problem Description
Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

Find and return the original numbers used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.



Problem Constraints
1 <= N <= 10000

1 <= A[i] <= 109



Input Format
The first and only argument given is the integer array A.



Output Format
Find and return the original numbers which are used to calculate the GCD array in any order.



Example Input
Input 1:

 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
Input 2:

 A = [5, 5, 5, 15]


Example Output
Output 1:

 [2, 8, 10]
Output 2:

 [5, 15]


Example Explanation
Explanation 1:

 Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 2 is the gcd between 2 and 8, 2 and 10.
 8 and 10 are the gcds pair with itself.
 Therefore, [2, 8, 10] is the original array.
Explanation 2:

 Initially, array A = [5, 5, 5, 15].
 5 is the gcd between 5 and 15.
 15 is the gcds pair with itself.
 Therefore, [5, 15] is the original array.
*/
public class AllGcdPair {
    public static void main(String[] args) {
        AllGcdPair obj = new AllGcdPair();
        int[] A = {2, 2, 2, 2, 8, 2, 2, 2, 10};
        System.out.println( obj.solve(ScaUtils.arrToArrayList(A)) );
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int countOfElementInRow1 = (int) Math.sqrt(A.size());
        ArrayList<Integer> ansArr = new ArrayList<>();
        for (int i=0; i<A.size(); i+=countOfElementInRow1){
            int max = Integer.MIN_VALUE;
            for (int j=0; j<countOfElementInRow1; j++){
                max = Math.max(max, A.get( i+j ) );
            }
            ansArr.add(max);
        }
        return ansArr;
    }
}
