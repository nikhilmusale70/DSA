package SortingRadixAndCountSort;

import adv12Utils.ScaUtils;

public class MaxUnsortedSubarray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19 };
        MaxUnsortedSubarray obj = new MaxUnsortedSubarray();
        ScaUtils.printNormalArray(obj.subUnsort(A));

    }
    public int[] subUnsort(int[] A) {
        int start=-1, end=-1;
        for (int i=0; i<A.length-1; i++){
            if(A[i]>A[i+1]){
                start =i;
                break;
            }
        }
        if(start == -1)
            return new int[]{-1};

        for (int j=A.length-1; j>0; j--){
            if(A[j-1]>A[j]){
                end = j;
                break;
            }
        }

        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;

        for (int i=start; i<=end; i++){
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        for (int i=0; i<start; i++){
            if (min<A[i]){
                start = i;
                break;
            }
        }
        for (int j=A.length-1; j>end; j--){
            if (max>A[j]){
                end = j;
                break;
            }
        }

        int[] ansArr = {start, end};
        return ansArr;
    }
}
