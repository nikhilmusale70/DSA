package AdvanceDSA_Arrays2;

import adv12Utils.ScaUtils;

import java.util.ArrayList;

public class SumOfAllSubmatrices {
    public static void main(String[] args) {
        int[][] arrList = {
                {1,1}, {1,1}
        };
        ArrayList<ArrayList<Integer>> A = ScaUtils.arrTo2dArrayList(arrList);
        solve(A);
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int rows=A.size(), col=A.get(0).size(), sum=0;

        for(int i=0; i<A.size(); i++){
            for(int j=0; j<A.get(i).size(); j++){
                int tl =(i+1)*(j+1);
                int br =(rows-i)*(col-j);
                sum += A.get(i).get(j)*tl*br;
            }
        }
        return sum;
    }

}
