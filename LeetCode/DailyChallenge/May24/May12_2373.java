package DailyChallenge.May24;

import java.util.Arrays;

public class May12_2373 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        May12_2373 obj = new May12_2373();
        System.out.println(Arrays.deepToString(obj.largestLocal(grid)));
    }
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid.length-2];

        for(int row=0; row<grid.length-2; row++){
            for(int col=0; col<grid.length-2; col++){
                ans[row][col] = findMax(grid, row, col);
            }
        }
        return ans;
    }
    int findMax(int[][] grid, int row, int col){
        int max = 0;
        for(int i=row; i<row+3; i++){
            for(int j=col; j<col+3; j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
