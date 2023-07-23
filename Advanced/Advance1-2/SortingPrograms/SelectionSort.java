package SortingPrograms;

import adv12Utils.ScaUtils;

public class
SelectionSort {
    public static void main(String[] args) {
        int[] A = {4,6,7,7,2,4,5,6,7};
        ScaUtils.printNormalArray(selectionSort(A));
    }

    static int[] selectionSort(int[] A){
        for (int i=0; i<A.length; i++){
            int idx = i;
            int min = A[i];
            for (int j=i+1; j<A.length; j++){
                if (A[j] < A[idx]){
                    idx = j;
                }
            }
            if(min>A[idx])
                swap(A, i, idx);
        }
        return A;
    }
    static int[] swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }
}
