package Maths1ModularArithmatic;

/*
Problem Description
Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

"^" means power,

"%" means "mod", and

"!" means factorial.



Problem Constraints
1 <= A, B <= 5e5



Input Format
First argument is the integer A

Second argument is the integer B



Output Format
Return one integer, the answer to the problem



Example Input
Input 1:

A = 1
B = 1
Input 2:

A = 2
B = 2


Example Output
Output 1:

1
Output 2:

4


Example Explanation
Explanation 1:

 1! = 1. Hence 1^1 = 1.
Explanation 2:

 2! = 2. Hence 2^2 = 4.

 */
public class VeryLargePower {
    public static void main(String[] args) {
        System.out.println(solve(2,27));
    }

    public static int solve(int A, int B) {
        return calFact(A,B);
    }

    public static int calFact(int A, int B){
        long mod = 1000000007;
        long fact = 1;
        for(int i=1; i<=B; i++) fact = i * (fact%(mod-1));
        fact %= mod-1;
        return calPower(A, (int)fact, (int)mod);
    }
    public static int calPower(int A, int B, int mod){
        if(A==0) return 0;
        if(B==0) return 1;

        long halfPower = (calPower(A, B/2, mod))%mod;
        long pow = (halfPower*halfPower)%mod;

        if((B&1)==0)return (int)(pow);
        else return (int)((pow*(A)%mod)%mod);
    }
}
