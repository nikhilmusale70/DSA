package SortingPrograms;

import adv12Utils.ScaUtils;

public class InsertionSort {
    public static void main(String[] args) {
        int[] A = {4,1,5,6,3,5,1};
        InsertionSort obj = new InsertionSort();
        System.out.println("Before: ");
        ScaUtils.printNormalArray(A);
        obj.insertionSort(A);
        System.out.println("After: ");
        ScaUtils.printNormalArray(A);
    }

    void insertionSort(int[] A){
        int i;
        int idx=0;
        for (int x: A) {
            for (i=idx; i>0; i--){
                if(A[i-1]>x){
                    A[i]=A[i-1];
                }
                else {
                    break;
                }
            }
            System.out.println("Nikhil :"+i +" : "+x + " IDX: "+idx);
            A[i]=x;
            idx++;
            System.out.println();
            ScaUtils.printNormalArray(A);
        }
    }
}
