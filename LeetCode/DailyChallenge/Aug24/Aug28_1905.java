package DailyChallenge.Aug24;

public class Aug28_1905 {
    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}},
                grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        Aug28_1905 obj = new Aug28_1905();
        System.out.println(obj.countSubIslands(grid1, grid2));
    }

    boolean subIsland;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] visited = new boolean[grid1.length][grid1[0].length];

        int ans = 0;
        for(int i=0; i<grid1.length; i++){
            for(int j=0; j<grid1[0].length; j++){
                if (grid2[i][j]==1 && !visited[i][j]){
                    subIsland = true;
                    dfs(grid1, grid2, i, j, visited);
                    if(subIsland) ans++;
                }
            }
        }
        return ans;
    }

    void dfs(int[][] grid1, int[][] grid2, int x, int y, boolean[][] visited){
        //if at anytime in recursion grid1 is 0, its not an island
        if (grid1[x][y]==0) subIsland = false;

        visited[x][y] = true;

        int[] xAxis = {-1, 0, 0, 1};
        int[] yAxis = {0, -1, 1, 0};

        for(int i=0; i<xAxis.length; i++){
            int newX = x + xAxis[i];
            int newY = y + yAxis[i];

            //out of bound condition
            if(newX<0 || newY<0 || newX>=grid2.length || newY>=grid2[0].length || grid2[newX][newY]==0) continue;

            if(grid2[newX][newY]==1 && !visited[newX][newY]){
                dfs(grid1, grid2, newX, newY, visited);
            }
        }
    }
}
