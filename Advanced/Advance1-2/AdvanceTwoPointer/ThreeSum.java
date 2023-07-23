package AdvanceTwoPointer;

import java.util.Arrays;

/*
* Problem Description
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108


Input Format
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format
Return a single integer denoting the sum of three integers which is closest to B.



Example Input
Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:


A = [1, 2, 3]
B = 6


Example Output
Output 1:

2
Output 2:

6


Example Explanation
Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6.*/
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] A = {-1, 2, 1, -4};
        int B = 1;
        System.out.println(obj.threeSumClosest(A,B));
    }
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);

        int a,b,c;
        int sumofABC = Integer.MAX_VALUE;

        for (int i=0; i<A.length; i++){
            a=A[i];
            //now apply logic of pointer where sum is B find b,c
            b=0; c=A.length-1;
            int sumOfBC=Integer.MAX_VALUE;
            while (b<c){
                if (i==b) b++;
                if (i==c) c--;

                int newB = B-a;

                //to find closet numbers we need to see the difference between them
                //B - (a+b+c) should be min as possible

                if( (A[b] + A[c]) > newB){
                    c--;
                }
                else if( A[b]+A[c] < newB){
                    b++;
                }
                else{
                    return a+A[b]+A[c];
                }
                sumOfBC = Math.min(sumOfBC, Math.abs(newB-A[b]+A[c]));
            }
            sumofABC = Math.min(sumofABC, Math.abs(B-(a+sumOfBC)));

            System.out.println("For i: " +i+ " Sum: " + sumofABC);
        }

        return sumofABC;
    }
}
