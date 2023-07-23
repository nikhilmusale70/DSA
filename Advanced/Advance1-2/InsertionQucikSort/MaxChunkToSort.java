package InsertionQucikSort;

import adv12Utils.ScaUtils;

import java.util.ArrayList;

/*
* Problem Description
Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.

What is the most number of chunks we could have made?



Problem Constraints
1 <= N <= 100000
0 <= A[i] < N



Input Format
The only argument given is the integer array A.



Output Format
Return the maximum number of chunks that we could have made.



Example Input
Input 1:

 A = [1, 2, 3, 4, 0]
Input 2:

 A = [2, 0, 1, 3]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 A = [1, 2, 3, 4, 0]
 To get the 0 in the first index, we have to take all elements in a single chunk.
Explanation 2:

 A = [2, 0, 1, 3]
 We can divide the array into 2 chunks.
 First chunk is [2, 0, 1] and second chunk is [3].
*/
public class MaxChunkToSort {
    public static void main(String[] args) {
        MaxChunkToSort obj = new MaxChunkToSort();
        int[] A = {2, 0, 1, 3};
        System.out.println(obj.solve(ScaUtils.arrToArrayList(A)));

    }

    public int solve(ArrayList<Integer> A) {
return 1;
    }
}
