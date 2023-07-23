package Maths1ModularArithmatic;
/*
Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

Since the answer may be large, return the answer modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 2
Input 2:

 A = [5, 17, 100, 11]
 B = 28


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
 So total 4 pairs.

 */
import java.util.HashMap;

public class PairSumdivisiblebyM {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(solve(A, 2));
    }

    public static int solve(int[] A, int B) {
        //check the modulo for each number, and store it in a map
        HashMap<Integer, Integer> hm = new HashMap<>();
        int mod = 1000000007;
        long count=0;

        for (int i=0; i<A.length; i++){
            int remainder = A[i]%B;
            if( hm.containsKey((B-remainder)%B) ){
                count += hm.get((B-remainder)%B);
            }
            hm.put(remainder, hm.getOrDefault(remainder, 0)+1);
            count %= mod;
        }
        return (int)count;
    }
}
