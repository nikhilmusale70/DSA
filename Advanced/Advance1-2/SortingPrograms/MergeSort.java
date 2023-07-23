package SortingPrograms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println("Given Arr: " + Arrays.toString(A));

        MergeSort ms = new MergeSort();
        ms.sort(A, 0, A.length-1);

        System.out.println("Sorted Arr: " + Arrays.toString(A));

    }

    void sort(int[] A, int start, int end){
        if(start<end){
            int mid = (start+end)/2;

            sort(A, start, mid);
            sort(A, mid+1, end);

            merge(A, start, mid, end);
        }
    }

    void merge(int[] arr, int start, int mid, int end){

        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i=0; i<n1; i++){
            leftArr[i] = arr[start+i];
        }
        for (int i=0; i<n2; i++){
            rightArr[i] = arr[mid+1+i];
        }

        int leftIndex =0; int rightIndex =0;
        int k = start;
        while (leftIndex<leftArr.length && rightIndex<rightArr.length){
            if(leftArr[leftIndex]>rightArr[rightIndex]){
                arr[k] = rightArr[rightIndex];
                rightIndex++;
                k++;
            }
            else {
                arr[k] = leftArr[leftIndex];
                leftIndex++;
                k++;
            }
        }

        while (leftIndex<leftArr.length){
            arr[k] = leftArr[leftIndex];
            leftIndex++;
            k++;
        }
        while(rightIndex<rightArr.length){
            arr[k] = rightArr[rightIndex];
            rightIndex++;
            k++;
        }
    }
}
