package SortingPrograms;

import adv12Utils.ScaUtils;

public class QuickSort {
    public static void main(String[] args) {
        int[] A= {4,2,5,2,1,4,6,3};
        QuickSort obj = new QuickSort();

        System.out.println("Before: ");
        ScaUtils.printNormalArray(A);

        obj.quickSort(0, A.length, A);

        System.out.println("After: ");
        ScaUtils.printNormalArray(A);
    }
    void quickSort(int start, int end, int[] A){
        if (start<end){
            int mid = (start+end)/2;
            partition(A);

            quickSort(start, mid, A);
            quickSort(mid+1, end, A);

        }
    }

    void partition(int[]  A){
        int pivotElem = A[0];
        int p=1, q=A.length-1;
        while (p<=q){
            if (A[p]<pivotElem){
                p++;
            }
            if(A[q]>=pivotElem){
                q--;
            }
            if(A[q]<pivotElem && A[p]>pivotElem && p<q) {
                swap(p, q, A);
            }
            if (p>=A.length){
                break;
            }
        }
        swap(0,q,A);
        //now the pivot element is on correct place
    }
    void swap(int p, int q, int[] A){
        //swap p and q index
        int temp = A[p];
        A[p] = A[q];
        A[q] = temp;
    }
}
