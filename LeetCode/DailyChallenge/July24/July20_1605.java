package DailyChallenge.July24;

import java.util.Arrays;

public class July20_1605 {
    public static void main(String[] args) {
        int[]rowSum = {3,8}, colSum = {4,7};
        July20_1605 obj = new July20_1605();
        System.out.println(Arrays.deepToString(obj.restoreMatrix(rowSum, colSum)));
    }
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];

        for(int i=0; i<rowSum.length; i++){
            matrix[i][0]=rowSum[i];
        }

        int x = 0, y=0;
        while(x<rowSum.length && y<colSum.length){
            matrix[x][y] = Math.min(rowSum[x], colSum[y]);

            rowSum[x] -= matrix[x][y];
            colSum[y] -= matrix[x][y];

            if(rowSum[x]==0){
                x++;
            } else{
                y++;
            }
        }
        return matrix;
    }
}
