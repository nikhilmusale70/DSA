package BitManipulationBasic.Homework;

import adv12Utils.ScaUtils;

import java.util.ArrayList;

public class DifferentBitsSumPairwise {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        ArrayList<Integer> A = ScaUtils.arrToArrayList(arr);
        System.out.println(cntBits(A));
    }
// f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5)
// = 0 +         1 +       1 +        1 +        0 +       2 +       1 +     2 +     0 = 8
    public static int cntBits(ArrayList<Integer> A) {
        int mod = 1000000007;
        long totalOne =0, totalZero =0;
        long totalSum=0;
        for(int index=0; index<32; index++){
            totalOne=0; totalZero=0;
            for(int i=0; i<A.size(); i++){
                if( ((1<<index)&A.get(i))!=0) {
                    totalOne = (totalOne%mod+1%mod)%mod;
                }
            }
            totalZero = (A.size()%mod-totalOne%mod +mod)%mod;
            totalSum += (totalOne%mod*totalZero%mod*2%mod)%mod;
        }

        return (int)(totalSum%mod);
    }
}
