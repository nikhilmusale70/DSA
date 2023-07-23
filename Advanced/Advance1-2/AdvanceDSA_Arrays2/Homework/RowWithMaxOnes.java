package AdvanceDSA_Arrays2.Homework;

public class RowWithMaxOnes {
    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(solve(A));
    }
    public static int solve(int[][] A) {
        int row=-1;
        int flag=0;
        // iterate on col
        for(int i=0; i<A[0].length; i++){
            for(int j=0; j<A.length; j++){
                if(A[j][i] == 1){
                    row=j;
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                break;
            }
        }
        return row;
    }
}
