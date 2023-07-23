package BinarySearchProblems;

import BinarySearch1.SortedInsertPosition;

/*Problem Description
Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index otherwise, return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 109

all elements in A are distinct.



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return index of B in array A, otherwise return -1



Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:

A : [ 9, 10, 3, 5, 6, 8 ]
B : 5


Example Output
Output 1:

 0
Output 2:

 3


Example Explanation
Explanation 1:

Target 4 is found at index 0 in A.
Explanation 2:

Target 5 is found at index 3 in A.*/
public class SortedRoatedSearch {
    public static void main(String[] args) {
        SortedInsertPosition obj = new SortedInsertPosition();
        int[] A= {4, 5, 6, 7, 0, 1, 2, 3}; int B=4;
        System.out.println(obj.searchInsert(A, B));
    }

    public int search(final int[] A, int B) {
        //search for roated element, how?
        //the start of small array that would be on right side would be always less than A[0];
        int indexOfMaxElem = indexOfMax(A);
        return Bs(A, B, indexOfMaxElem);
    }

    int indexOfMax(int[] A){
        int l=0, r=A.length-1;
        int ans=0;
        while (l<=r){
            int mid = l + (r-l)/2;
            if (A[mid]<A[0])
                r=mid-1;
            else{
                ans = mid;
                l=mid+1;
            }
        }
        return ans;
    }
    int Bs(int[] A, int B, int num){
        int l, r;
        if(A[0]>B){
            l=num+1;
            r=A.length-1;
        }
        else {
            l = 0;
            r = num;
        }
        while (l<=r){
            int mid = l+(r-l)/2;
            if (A[mid]==B)
                return mid;
            else if(A[mid]<B)
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
}
