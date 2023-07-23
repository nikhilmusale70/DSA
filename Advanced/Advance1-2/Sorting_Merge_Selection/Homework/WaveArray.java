package Sorting_Merge_Selection.Homework;

import java.util.Arrays;

/*
Problem Description
Given an array of integers A, sort the array into a wave-like array and return it.
In other words, arrange the elements into a sequence such that

a1 >= a2 <= a3 >= a4 <= a5.....
NOTE: If multiple answers are possible, return the lexicographically smallest one.



Problem Constraints
1 <= len(A) <= 106
1 <= A[i] <= 106



Input Format
The first argument is an integer array A.



Output Format
Return an array arranged in the sequence as described.



Example Input
Input 1:

A = [1, 2, 3, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[2, 1, 4, 3]
Output 2:

[2, 1]


Example Explanation
Explanation 1:

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
First answer is lexicographically smallest. So, return [2, 1, 4, 3].
Explanation 1:

Only possible answer is [2, 1].



See Expected Output
Your input
8 1 2 3 4 5 6 7 8
Output
2 1 4 3 6 5 8 7
 */
public class WaveArray {
    public static void main(String[] args) {
        int[] A = {3,1,2,5,4,7,6,8};
        WaveArray obj = new WaveArray();
        System.out.println(Arrays.toString(obj.wave(A)));
    }
    public int[] wave(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        length = (A.length & 1) == 0? A.length : A.length-1;
        for (int i=0; i<length; i+=2){
            swap(A, i, i+1);
        }
        return A;
    }

    void swap(int[] A, int s, int e){
        int temp = A[s];
        A[s] = A[e];
        A[e] = temp;
    }
}
