package Math2GCD;
/*
Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints

2 <= N <= 105
1 <= A[i] <= 109



Input Format

First argument is an integer array A.



Output Format

Return an integer denoting the maximum value of GCD.



Example Input

Input 1:

 A = [12, 15, 18]
Input 2:

 A = [5, 15, 30]


Example Output

Output 1:

 6
Output 2:

 15


Example Explanation

Explanation 1:


 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.

 */
public class DeleteOne {

    public static void main(String[] args) {
        int[] A = {12, 15, 18};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int[] preFixGcd = new int[A.length];
        preFixGcd[0] = A[0];
        for(int i=1; i<A.length; i++){
            preFixGcd[i] = gcd(A[i], preFixGcd[i-1]);
        }

        int[] suffixGcd = new int[A.length];
        suffixGcd[A.length-1] = A[A.length-1];
        for (int i=A.length-2; i>=0; i--){
            suffixGcd[i] = gcd(A[i], suffixGcd[i+1]);
        }

        int maxGcd = 0;
        maxGcd = suffixGcd[1];
        for (int i=1; i<A.length-1; i++){
            maxGcd = Math.max(maxGcd, gcd(suffixGcd[i+1], preFixGcd[i-1]));
        }
        maxGcd = Math.max(maxGcd, preFixGcd[A.length-2]);

        return maxGcd;
    }

    public static int gcd(int a, int b){
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        if(b==0) return a;

        return gcd(a%b, b);
    }
}
