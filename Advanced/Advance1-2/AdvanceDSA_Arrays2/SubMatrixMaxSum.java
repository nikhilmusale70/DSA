package AdvanceDSA_Arrays2;

public class SubMatrixMaxSum {
    public static void main(String[] args) {
        int[][]A  = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(solve(A));
    }
    public static long solve(int[][] A) {
        long[][] prefMat = preFixMat(A);
        long maxSum = A[A.length-1][A[0].length-1];
        long sum;
        int x1 ,x2=A.length-1 ,y1, y2=A[0].length-1;

        for(int n=0; n<A.length; n++){
            for (int m=0; m<A[0].length; m++){
                sum = findSum(prefMat, n, m, x2, y2);
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

    public static long findSum(long[][] A, int x1, int y1, int x2, int y2){
        long ans = A[x2][y2];

        if(x1==0 && y1==0){
            return ans;
        }
        if(x1==0){
            ans -= A[x2][y1-1];
        }
        if(y1==0){
            ans -= A[x1-1][y2];
        }

        if(x1>0&& y1>0){
            ans += A[x1-1][y1-1] - A[x2][y1-1] - A[x1-1][y2];
        }
        return ans;
    }

    public static long[][] preFixMat(int[][] A){
        long[][] prefMat = new long[A.length][A[0].length];

        //row
        for(int i=0; i<A.length; i++){
            prefMat[i][0]=A[i][0];
            for (int j=0; j<A[i].length; j++){
                if(j>0){
                    prefMat[i][j] = A[i][j] + prefMat[i][j-1];
                }
            }
        }

        //col
        for(int i=0; i<A[0].length; i++){
            prefMat[0][i]=prefMat[0][i];
            for (int j=0; j<A.length; j++){
                if(j>0){
                    prefMat[j][i] = prefMat[j][i] + prefMat[j-1][i];
                }
            }
        }
        return prefMat;
    }
}
