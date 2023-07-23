/*
Problem Description
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).

Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.



Problem Constraints
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109


Input Format
Given three integers A, B, C.


Output Format
Return an integer.


Example Input
A = 2, B = 3, C = 3


Example Output
2


Example Explanation
23 % 3 = 8 % 3 = 2
*/
package Recursion2;

public class ImplementPowerFunction {
    public static void main(String[] args) {
        System.out.println(pow(2,2, 7));
    }
    public static int pow(int A, int B, int C) {
        if(B==0){
            return 1;
        }
        long ha = (pow(A, B/2, C))%C;

        if(B%2==0){
            return (int) ((ha*ha)%C);
        }
        else{
            return (int) ((ha*ha*A)%C);
        }
    }
}
