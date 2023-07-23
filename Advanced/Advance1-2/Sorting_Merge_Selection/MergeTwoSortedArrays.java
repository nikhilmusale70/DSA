package Sorting_Merge_Selection;

import adv12Utils.ScaUtils;

/*
* Problem Description
Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.



Problem Constraints
-1010 <= A[i], B[i] <= 1010



Input Format
First Argument is a 1-D array representing A.

Second Argument is also a 1-D array representing B.



Output Format
Return a 1-D vector which you got after merging A and B.



Example Input
Input 1:

A = [4, 7, 9 ]
B = [2, 11, 19 ]
Input 2:

A = [1]
B = [2]


Example Output
Output 1:

[2, 4, 7, 9, 11, 19]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

Merging A and B produces the output as described above.
Explanation 2:

 Merging A and B produces the output as described above.

*/
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[]A ={2,5,6,7};
        int[]B ={1, 5,5,5,5,5, 76};
        ScaUtils.printNormalArray(solve(A,B));
    }

    public static int[] solve(final int[] A, final int[] B) {
        int[] ansArr = new int[A.length+B.length];
        int indexLeft =0, indexRight=0;
        for (int k=0; k<ansArr.length; k++){
            if(indexLeft == A.length){
                ansArr[k] = B[indexRight];
                indexRight++;
            }
            else if(indexRight == B.length){
                ansArr[k] = A[indexLeft];
                indexLeft++;
            }
            else if(A[indexLeft]>B[indexRight]){
                ansArr[k] = B[indexRight];
                indexRight++;
            }
            else {
                ansArr[k] = A[indexLeft];
                indexLeft++;
            }
            System.out.println("For K: "+k+" : "+ansArr[k]);
        }
        return ansArr;
    }
}
