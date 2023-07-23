package SortingPrograms;

import adv12Utils.ScaUtils;

public class MergeAlgo {
    public static void main(String[] args) {
        int[] B= {8}; int[] C= {6};
        int[] A = new int[B.length+C.length];
        ScaUtils.printNormalArray(merge(B,C,A));
    }

    static int[] merge(int[] leftArr, int[] rightArr, int[] ansArr){
        int indexLeft=0, indexRight=0;

        for (int k=0; k<leftArr.length + rightArr.length; k++){
            if (indexLeft==leftArr.length){
                ansArr[k] = rightArr[indexRight];
                indexRight++;
            }
            else if(indexRight==rightArr.length){
                ansArr[k] = leftArr[indexLeft];
                indexLeft++;
            }

            else if (leftArr[indexLeft]<rightArr[indexRight]) {
                ansArr[k] = leftArr[indexLeft];
                indexLeft++;
            }
            else{
                ansArr[k] = rightArr[indexRight];
                indexRight++;
            }
        }
        return ansArr;
    }
}
