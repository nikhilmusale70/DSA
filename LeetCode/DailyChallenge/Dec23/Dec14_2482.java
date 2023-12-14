package DailyChallenge.Dec23;

import java.util.Arrays;

public class Dec14_2482 {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1},{1,0,1},{0,0,1}};
        Dec14_2482 obj = new Dec14_2482();
        System.out.println(Arrays.deepToString(obj.onesMinusZeros(grid)));
    }
    public int[][] onesMinusZeros(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }


        int[][] diff = new int[grid.length][grid[0].length];
        for(int i=0; i<diff.length; i++){
            for(int j=0; j<diff[0].length; j++){
                diff[i][j] = 2*(row[i] + col[j]) -grid.length-grid[0].length;
            }
        }
        return diff;
    }
}
