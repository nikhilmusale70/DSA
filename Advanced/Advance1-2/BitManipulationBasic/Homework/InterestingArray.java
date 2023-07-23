package BitManipulationBasic.Homework;

import adv12Utils.ScaUtils;

import java.util.ArrayList;

public class InterestingArray {
    public static void main(String[] args) {
        int[] arr = {9, 17};
        ArrayList<Integer> A = ScaUtils.arrToArrayList(arr);
        System.out.println(solve(A));
    }

    public static String solve(ArrayList<Integer> A) {
        long totalSum=0;
        for(int i=0; i<A.size(); i++){
            totalSum += A.get(i);
        }
        return (totalSum&1)==0? "Yes" : "No";
    }
}
