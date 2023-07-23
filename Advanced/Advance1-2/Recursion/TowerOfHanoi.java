package Recursion;

import adv12Utils.ScaUtils;

public class TowerOfHanoi {
    public static void main(String[] args) {

        ScaUtils.print2dArray(towerOfHanoi(2));
    }


    public static int[][] towerOfHanoi(int A) {
        int m = (int)(Math.pow(2,A) - 1);
        ansTower = new int[m][3];
        tower(A, 1,3,2);
        return ansTower;
    }
    static int counter = 0;
    static int[][] ansTower;

    public static void tower(int numOfDisk, int source, int target, int helper){
        if (numOfDisk==0){
            return;
        }
        tower(numOfDisk-1, source, helper, target);

        System.out.println(numOfDisk + "" + source + ""+ target + " " + counter);
        ansTower[counter][0] = numOfDisk;
        ansTower[counter][1] = source;
        ansTower[counter][2] = target;
        counter++;

        tower(numOfDisk-1, helper,target,source);

        return;
    }
}
