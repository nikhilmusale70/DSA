package AdvanceDsa_Arrays1;

import adv12Utils.ScaUtils;

public class BeggarsPot {
    public static void main(String[] args) {
        int[][] B = {
                {1, 3, 10},
                {6, 9, 2},
                {3, 5, 3},
                {2, 8, 4},
                {6, 7, 5}
    };
        ScaUtils.printNormalArray(solve(10, B));
    }
    public static int[] solve(int A, int[][] B) {
        int[] beggarsPot = new int[A];

        ScaUtils.printNormalArray(beggarsPot);

        for(int i=0; i<B.length; i++){
            if(B[i][0]<=0) B[i][0] = 1;
            beggarsPot[B[i][0]-1] += B[i][2];

            if(B[i][1]>A) continue;
            beggarsPot[B[i][1]] += 0-B[i][2];
        }

        System.out.println("Beggarspot AFTER");
        ScaUtils.printNormalArray(beggarsPot);
        System.out.println();

        for(int i=1; i<beggarsPot.length; i++){
            beggarsPot[i] = beggarsPot[i-1] + beggarsPot[i];
        }

        return beggarsPot;
    }
}
