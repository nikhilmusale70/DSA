package AdvanceDSA_Arrays2.Homework;

public class MinimumSwaps {
    public static void main(String[] args) {
        int[] A = {52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17,
                13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16,
                83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36,
                21, 94, 46, 52, 47, 87, 33, 87, 70};
        System.out.println("Min swaps : "+solve(A, 19));
    }

    public static int solve(int[] A, int B) {
        int count=0, continousCount=0, tempCount=0;
        for(int i=0; i<A.length; i++){
            if(A[i]<=B) {
                count++;
            }
        }
        int windowSize = count;
        int swaps=0, minSwaps=0;

        //count of swaps for first window
        for (int i=0; i<windowSize; i++){
            if(A[i]>B){
                swaps++;
            }
        }
        minSwaps = swaps;
//        System.out.println("Window size: "+windowSize);
        //count from further on
        for (int i=windowSize; i<A.length; i++){
//            System.out.print("Removing :"+A[i-windowSize] + " ");
            if(A[i-windowSize]>B){
                swaps--;
            }
//            System.out.print("Adding :"+A[i]);
            if(A[i]>B){
                swaps++;
            }
            minSwaps = Math.min(swaps, minSwaps);
//            System.out.println(" Min swaps : "+ minSwaps);
        }

        return minSwaps;
    }
}
