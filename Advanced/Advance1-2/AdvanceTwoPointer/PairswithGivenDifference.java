package AdvanceTwoPointer;

import adv12Utils.ScaUtils;

import java.util.Arrays;

public class PairswithGivenDifference {
    public static void main(String[] args) {
        PairswithGivenDifference obj =new PairswithGivenDifference();
        int[] A={ 8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        int B=3;
        System.out.println(obj.solve(A,B));
    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        ScaUtils.printNormalArray(A);
        int l=0, r=1;
        int ans=0;
        while (r<A.length){
            if (l>0 && A[l]==A[l-1] && A[r]==A[r-1]){
                l++;r++;
                continue;
            }

            if (A[r]-A[l]<B){
                r++;
            }
            else if(A[r]-A[l]==B){
                ans++;
                l++;
                r++;
            }
            else {
                l++;
            }
            if (r==l){
                r++;
            }
        }
        return ans;
    }
}
