package BinarySearch1;
/*
* Problem Description
Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.*/
public class PeakElement {
    public static void main(String[] args) {
        int[] A = { 2, 3};
        PeakElement obj = new PeakElement();
        System.out.println(obj.solve(A));
    }

    public int solve(int[] A) {
        int l=0, r=A.length-1;
        int mid=-1;
        while(l<=r){
            mid = (l+r)/2;
            System.out.println(mid);
            if (mid==A.length-1 )
                return A[mid];
            if (mid==0)
                return A[0]>A[1]?A[0]:A[1];

            if (A[mid]>A[mid-1] && A[mid]>A[mid+1]){
                return A[mid];
            }
            else {
                if (A[mid] < A[mid - 1]) {
                    r = mid -1;
                }
                else{
                    l = mid+1;
                }
            }
        }
        return mid;
    }
}
