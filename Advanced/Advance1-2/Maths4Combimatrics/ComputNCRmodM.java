package Maths4Combimatrics;

/*
* Problem Description
Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.



Problem Constraints
1 <= A * B <= 106

1 <= B <= A

1 <= C <= 106



Input Format
The first argument given is integer A ( = n).
The second argument given is integer B ( = r).
The third argument given is integer C ( = m).


Output Format
Return the value of nCr % m.



Example Input
Input 1:

 A = 5
 B = 2
 C = 13
Input 2:

 A = 6
 B = 2
 C = 13


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

 The value of 5C2 % 11 is 10.
Explanation 2:

 The value of 6C2 % 13 is 2.
 * */

public class ComputNCRmodM {
    public static void main(String[] args) {
        System.out.println(solve(9902,3113,422753));
    }
    public static int solve(int A, int B, int C) {
        long nfact = calFact(A, C);
//        long nrFact = calFact(A-B, C);
//        long rFact = calFact(B, C);
        long denominator = ((long) calFact(A - B, C) * calFact(B, C))%C;
        long invDeno = calPow(denominator, C-2, C)%C;

//        long invNrFact = calPow(denominator, C-2, C);
//        long invRFact = calPow(rFact, C-2, C);


        long ans = ( nfact * invDeno )%C ;
        return (int)ans;

    }
    //195574
    public static int calPow(long number, long power, long mod){

        if(power==0) return 1;

        long he = calPow(number, power/2, mod)%mod;
        long ha = (he*he)%mod;

        if(power%2==0) {
            return (int) ha;
        }
        else {
            return (int)( (number*ha)%mod);
        }
    }

    public static int calFact(int number, int mod){
        long fact=1;
        for (int i=2; i<=number; i++){
            fact = (fact * i%mod)%mod;
        }
        return (int)fact;
    }
}
