package Maths1ModularArithmatic.Homework;

import adv12Utils.ScaUtils;

import java.util.ArrayList;

/*
Given an array A of size N. Rearrange the given array so that A[i] becomes A[A[i]] with O(1) extra space.

Constraints:

1 <= N <= 5×104

0 <= A[i] <= N - 1

The elements of A are distinct

Input Format

The argument A is an array of integers

Example 1:

Input : [1, 0]
Return : [0, 1]
Example 2:

Input : [0, 2, 1, 3]
Return : [0, 1, 2, 3]
 */
public class RearrangeArray {
    public static void main(String[] args) {
        int[] A = {4, 0, 2, 1, 3};
        RearrangeArray obj = new RearrangeArray();
        obj.arrange(ScaUtils.arrToArrayList(A));

    }
    public void arrange(ArrayList<Integer> a) {
        int n=a.size();
        System.out.println(a);
        for (int i=0; i<a.size(); i++){
            int varToSet = a.get(i) + (a.get(a.get(i))%n)*n;
            a.set(i, varToSet);
        }

        for (int i=0; i<n; i++){
            a.set(i, a.get(i)/n);
        }
        System.out.println(a);
    }
}
