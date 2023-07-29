package Graph1;

public class NumberOfIsland {

    public static void main(String[] args) {
        int[][] A = {
                {0,0,1,0,1,0,1,0,1},
                {0,1,0,0,0,1,0,1,0}};
        System.out.println(new NumberOfIsland().solve(A));
    }
    public int solve(int[][] A) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        int count = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[i].length; j++){
                if(A[i][j] == 1 && !visited[i][j]){
                    dfs(A, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int[][] A, int x, int y, boolean[][] visited){
        visited[x][y] = true;

        int[] xAxis = {-1, 0, 0, 1, -1,  -1,  1, 1};
        int[] yAxis = {0, -1, 1, 0, -1,   1,  1,-1};

        for(int i=0; i<xAxis.length; i++){
            int newX = x + xAxis[i];
            int newY = y + yAxis[i];

            //out of bound condition
            if(newX<0 || newY<0 || newX>=A.length || newY>=A[0].length || A[newX][newY]==0) continue;

            if(A[newX][newY]==1 && !visited[newX][newY]){
                dfs(A, newX, newY, visited);
            }
        }
    }
}
