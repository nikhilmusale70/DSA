package DailyChallenge.April24;

public class April18_463 {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        April18_463 obj = new April18_463();
        System.out.println(obj.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int[] x = {-1, 0, 0, 1};
        int[] y = {0, -1, 1, 0};
        int ans = 0;


        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    //land
                    //if surrounded by land don't consider that side in perimeter
                    for(int idx=0; idx<4; idx++){
                        int newX = i + x[idx];
                        int newY = j + y[idx];
                        if(isValid(newX, newY, grid)){
                            if(grid[newX][newY] == 0){
                                ans++;
                            }
                        }
                        else{
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
    boolean isValid(int x, int y, int[][] grid){
        if(x>=0 && y>=0 && x<grid.length && y<grid[0].length){
            return true;
        }
        return false;
    }
}
