package SortingRadixAndCountSort;

import adv12Utils.ScaUtils;

/*
Problem Description
Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.


Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 105


Input Format
The first argument is an integer array A.


Output Format
Return an integer array that is the sorted array A.


Example Input
Input 1:
A = [1, 3, 1]
Input 2:
A = [4, 2, 1, 3]


Example Output
Output 1:
[1, 1, 3]
Output 2:
[1, 2, 3, 4]


Example Explanation
For Input 1:
The array in sorted order is [1, 1, 3].
For Input 2:
The array in sorted order is [1, 2, 3, 4].

 */
public class CountSort {
    public static void main(String[] args) {
        int a[] = {10,9,8};
        CountSort ans = new CountSort();
        System.out.println("NIKHIL: ");
        ScaUtils.printNormalArray(ans.solve(a));
    }
    public int[] solve(int[] A) {
        int max= Integer.MIN_VALUE;
        for (int i=0; i<A.length; i++){
            max = Math.max(max, A[i]);
        }
        int[] numArr = new int[max+1];
        for (int i=0; i<A.length; i++){
            numArr[A[i]]++;
        }
        int counter =0;
        for (int i=0;i<=max; i++){
            for (int j=0; j<numArr[i]; j++){
                A[counter] = i;
                counter++;
            }
        }
        return A;
    }
}
