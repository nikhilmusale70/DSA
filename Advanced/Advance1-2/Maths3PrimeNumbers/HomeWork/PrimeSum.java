package Maths3PrimeNumbers.HomeWork;

import adv12Utils.ScaUtils;

import java.util.Arrays;

/*
Problem Description
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

If there is more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.
NOTE: A solution will always exist. Read Goldbach's conjecture.



Problem Constraints
4 <= A <= 2*107



Input Format
First and only argument of input is an even number A.



Output Format
Return a integer array of size 2 containing primes whose sum will be equal to given number.



Example Input
 4


Example Output
 [2, 2]


Example Explanation
 There is only 1 solution for A = 4.

 */
public class PrimeSum {
    public static void main(String[] args) {
        int A = 16;
        ScaUtils.printNormalArray(primesum(A));
    }
    public static int[] primesum(int A) {
        calSieveArr(A);
        int[] ans = new int[2];
        for (int i=2; i<A; i++){
            if (sieveArr[i]&&sieveArr[A-i]){
                ans[0]=i;
                ans[1] = A-i;
                break;
            }
        }
        return ans;
    }
    static boolean[] sieveArr;
    public static void calSieveArr(int num){
        sieveArr = new boolean[num];
        Arrays.fill(sieveArr, 2,num,true);

        for (int i=2; i*i<num; i++){
            if (sieveArr[i]){
                for (int j=i*i; j<num; j+=i){
                    sieveArr[j]=false;
                }
            }
        }
    }
}
