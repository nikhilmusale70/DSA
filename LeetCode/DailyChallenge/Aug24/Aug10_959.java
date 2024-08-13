package DailyChallenge.Aug24;

import java.util.Arrays;

public class Aug10_959 {
    public static void main(String[] args) {
        String[] grid = {"/\\","\\/"};
        Aug10_959 obj = new Aug10_959();
        System.out.println(obj.regionsBySlashes(grid));
    }

    int n;
    public int regionsBySlashes(String[] grid) {
        n = grid.length*3;
        int[][] matrix = createGrid(grid);
        visited = new boolean[n][n];

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]!=1 && !visited[i][j]){
                    dfs(matrix, i, j);
                    ans++;
                }
            }
        }

        return ans;

    }
    boolean[][] visited;
    int[] row = {1, 0, 0, -1};
    int[] col = {0, -1, 1, 0};
    void dfs(int[][] matrix, int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int newRow = row[i]+x;
            int newCol = col[i]+y;
            if(checkValid(newRow, newCol) && !visited[newRow][newCol] && matrix[newRow][newCol]!=1){
                dfs(matrix, newRow, newCol);
            }
        }
    }

    boolean checkValid(int x, int y){
        return x < n && y < n && x >= 0 && y >= 0;
    }

    int[][] createGrid(String[] grid){
        int[][] matrix = new int[n][n];
        int row=0, col=0;

        for(String str: grid){
            for(char ch: str.toCharArray()){
                if(ch=='/'){
                    matrix[row][col+2] = 1;
                    matrix[row+1][col+1] = 1;
                    matrix[row+2][col] = 1;
                }
                else if(ch=='\\'){
                    matrix[row][col] = 1;
                    matrix[row+1][col+1] = 1;
                    matrix[row+2][col+2] = 1;
                }
                col+=3;
            }
            row+=3;
            col=0;
        }
        return matrix;
    }
}
