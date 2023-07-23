package SortingPrograms;

import adv12Utils.ScaUtils;

public class Partition {
    public static void main(String[] args) {
        int[] A= {4,2,5,2,1,4,6,3};
//        int[] A = {6,8,5,1,7};
        Partition obj = new Partition();


        System.out.println("Before: ");
        ScaUtils.printNormalArray(A);
        obj.partition(A.length-1, A);
        System.out.println("After: ");
        ScaUtils.printNormalArray(A);
//        System.out.println("Final: "+ );
    }
    void partition(int pivotElem, int[]  A){
        int p=0, q=A.length-1;
        System.out.println();
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
