package AdvanceTwoPointer;
/*
* Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:


A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.*/
public class PairWithSumB {

    public static void main(String[] args) {
        int[] A = {1, 1, 1};
        int B=2;
        PairWithSumB obj = new PairWithSumB();
        System.out.println(obj.solve(A,B));
    }

    public int solve(int[] A, int B) {
        int l=0, r=A.length-1;
        long ans=0;
        while (l<r){
            long sum = A[l] + A[r];
            if (sum==B){
                int a = A[l];
                int b = A[r];

                if (A[l] == A[r]){
                    long count = r-l+1;
                    count = count * (count-1);
                    count >>= 1;
                    ans += count;
                    break;
                }

                long acount = 0;
                while(l<A.length && a==A[l]){
                    l++;
                    acount++;
                }
                long bcount = 0;
                while(r<A.length && b==A[r]){
                    r--;
                    bcount++;
                }
                ans += acount * bcount;
            }
            else if(sum<B)
                l++;
            else r--;
        }
        int mod = 1000000007;
        return (int) (ans%mod);
    }
}
