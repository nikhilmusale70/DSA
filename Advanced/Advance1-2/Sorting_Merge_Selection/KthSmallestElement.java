package Sorting_Merge_Selection;

import adv12Utils.ScaUtils;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] A={8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81,
                42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11,
                39, 62, 20, 17, 46, 26, 81, 92};
        System.out.println(kthsmallest(A, 9));
    }
    public static int kthsmallest(final int[] A, int B) {
        int indexOfTempMin;
        for (int i=0; i<A.length; i++){
            indexOfTempMin = i;
            for (int j=i+1; j<A.length; j++){
                if(A[j]<A[indexOfTempMin]){
                    indexOfTempMin =j;
                }
            }
            if(i <indexOfTempMin){
                swap(A, i, indexOfTempMin);
            }
            System.out.println("Smallest elem for i: "+i+ " : " + A[indexOfTempMin]);
        }
        System.out.println();
        ScaUtils.printNormalArray(A);
        System.out.println();
        System.out.println();
        return A[B];
    }

    static int[] swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }
}
