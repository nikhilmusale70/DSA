package DailyChallenge.oct24;

public class oct29_2684 {
    public static void main(String[] args) {
        int[][] grid = {{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        oct29_2684 obj = new oct29_2684();
        System.out.println(obj.maxMoves(grid));
    }
    public int maxMoves(int[][] grid) {
        backTrack(grid, 0, 0, 0);
        return ans;
    }

    int ans = 0;

    void backTrack(int[][] grid, int x, int y, int temp){
        int curr = grid[x][y];
        for(int i=-1; i<2; i++){
            if(y+1>=grid[0].length){
                ans = Math.max(ans, temp);
                return;
            }
            if(x+i<0 || x+i>=grid.length) {
                continue;
            }
            int newElement = grid[x + i][y + 1];
            if(newElement > curr){
                backTrack(grid, x+i, y+1, temp+1);
            }
            ans = Math.max(ans, temp);
        }
    }
}
