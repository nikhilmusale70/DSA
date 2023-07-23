package AdvanceDsa_Interview_Problems;

public class WaterTrapped {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2};
        System.out.println(trap(A));
    }

    public static int trap(final int[] A) {
        int[] prefixMax = new int[A.length];
        int[] suffixMax = new int[A.length];
        int sumOfWaterTrapped=0;

        prefixMax[0]=A[0];
        for (int i=1; i<A.length; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], A[i]);
        }

        suffixMax[A.length-1]=A[A.length-1];
        for (int i=A.length-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], A[i]);
        }

        //for ith building cal water it can store
        for (int i=1; i<A.length-1; i++){
            int leftMax = prefixMax[i-1];
            int rightMax = suffixMax[i+1];
            int minItCanStore = Math.min(leftMax, rightMax);
            int sumOfIthBuilding = minItCanStore-A[i];
            sumOfIthBuilding = Math.max(sumOfIthBuilding, 0);
            sumOfWaterTrapped += sumOfIthBuilding;
        }
        return sumOfWaterTrapped;
    }
}
