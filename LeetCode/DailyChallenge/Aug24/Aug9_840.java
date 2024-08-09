package DailyChallenge.Aug24;

public class Aug9_840 {
    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        Aug9_840 obj = new Aug9_840();
        System.out.println(obj.numMagicSquaresInside(grid));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        if(grid.length<2 || grid[0].length<2) return 0;

        for(int i=0; i<grid.length-2; i++){
            for(int j=0; j<grid[i].length-2; j++){
                if(isGridMagic(i, j, grid)){
                    ans++;
                }
            }
        }
        return ans;
    }

    boolean isGridMagic(int x, int y, int[][] grid){
        boolean[] visited = new boolean[10];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int num = grid[x+i][y+j];
                if(num<1 || num>9) return false;
                if(visited[num]) return false;
                visited[num] = true;
            }
        }

        int col1 = grid[x][y] + grid[x+1][y] + grid[x+2][y];
        int col2 = grid[x][y+1] + grid[x+1][y+1] + grid[x+2][y+1];
        int col3 = grid[x][y+2] + grid[x+1][y+2] + grid[x+2][y+2];

        if(col1!=col2 && col2!=col3) return false;

        int row1 = grid[x][y] + grid[x][y+1] + grid[x][y+2];
        int row2 = grid[x+1][y] + grid[x+1][y+1] + grid[x+1][y+2];
        int row3 = grid[x+2][y] + grid[x+2][y+1] + grid[x+2][y+2];

        if(row1!=row2 && row2!=row3) return false;

        int diagonal1 = grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2];
        int diagonal2 = grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y];

        if(diagonal1 != diagonal2) return false;

        return true;

    }
}
