package SortingRadixAndCountSort;

import java.util.Arrays;

public class SumDifferenceMaxMin {
    public static void main(String[] args) {
        int[] a = {3, 5, 10};
        SumDifferenceMaxMin obj = new SumDifferenceMaxMin();
        System.out.println(obj.solve(a));
    }
    public int solve(int[] A) {
        int mod = 1000000007;
        Arrays.sort(A);
        long submax=0, submin=0, pow=1;
        for (int i=0; i<A.length; i++){
            submax = (submax + (A[i]*pow)%mod)%mod;
            pow = (pow * 2)%mod;
        }
        pow =1;
        for (int j=A.length-1; j>=0; j--){
            submin = (submin + (A[j]*pow)%mod)%mod;
            pow = (pow * 2)%mod;
        }

        return (int) ((submax-submin + mod)%mod);
    }
}
