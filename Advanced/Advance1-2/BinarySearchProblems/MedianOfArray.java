package BinarySearchProblems;

import adv12Utils.ScaUtils;

import java.util.List;

/*
* Problem Description
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.


Problem Constraints
1 <= N + M <= 2*106



Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.



Output Format
Return a decimal value denoting the median of two sorted arrays.



Example Input
Input 1:

 A = [1, 4, 5]
 B = [2, 3]
Input 2:

 A = [1, 2, 3]
 B = [4]


Example Output
Output 1:

 3.0
Output 2:

 2.5


Example Explanation
Explanation 1:

 The median of both the sorted arrays will be 3.0.
Explanation 2:

 The median of both the sorted arrays will be (2+3)/2 = 2.5.*/
public class MedianOfArray {
    public static void main(String[] args) {
        MedianOfArray obj = new MedianOfArray();
//        int[] A = {1,2,3,4,5};
//        int[] B = {1,2,3 };
        int[] A = {-24, -11, -7, 4, 21, 26 };
        int[] B = {25, 44};
        System.out.println(obj.findMedianSortedArrays(ScaUtils.arrToArrayList(A), ScaUtils.arrToArrayList(B)));
    }

    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        //considering a to be big arr and b to be small
        if (a.size() < b.size())
            return findMedianSortedArrays(b,a);
        int total = a.size() + b.size();
        int half = total/2;
        int l=0, r=b.size()-1;
        if (l>r){
            int mid = a.size()>1?(a.size()-1)/2 : 0;
            //median will exist in a only
            //check even odd then return
            if((a.size()&1)==0){
                //even
                return (a.get(mid)+a.get(mid+1))/2.0;
            }
            else
                return a.get(mid);
        }

        while (l<=r){
            int midB = (l+r)/2;
            int midA = half - midB -2;

            //compare left with right, and right with left
            int leftB = midB>=0?b.get(midB):Integer.MIN_VALUE;
            int rightB = midB<b.size()-1? b.get(midB+1):Integer.MAX_VALUE;

            int leftA = midA>=0? a.get(midA):Integer.MIN_VALUE;
            int rightA = midA<a.size()-1? a.get(midA+1):Integer.MAX_VALUE;

            if (leftB<=rightA && leftA<=rightB){
                //desired condition
                if ((total&1)==0){
                    //even
                    return ( (Math.max(leftA, leftB) + Math.min(rightA, rightB))/2.0 );
                }
                else
                    return Math.min(rightA, rightB);
            }
            else if(leftB>rightA)
                r = midB-1;
            else
                l = midB+1;
        }

        //ans now lies in first arr, min of rightA and rightB
        if ((total&1)==0){
            //even
            int fromLeftpartition = a.get(half-1);
            int fromRightPartition = Math.min(a.get(half), b.get(0));
            return (fromLeftpartition+fromRightPartition)/2.0;
        }
        else
            return Math.min(a.get(half), b.get(0));
    }
}
