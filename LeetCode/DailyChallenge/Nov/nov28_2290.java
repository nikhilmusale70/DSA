package DailyChallenge.Nov;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class nov28_2290 {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1},{1,1,0},{1,1,0}};
        nov28_2290 obj = new nov28_2290();
        System.out.println(obj.minimumObstacles(grid));
    }

    int[] rowDirection = {1,0,0,-1};
    int[] colDirection = {0,1,-1,0};

    int[][] minObstacles;
    public int minimumObstacles(int[][] grid) {
        minObstacles = new int[grid.length][grid[0].length];
        for(int[] arr: minObstacles){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        return bfs(grid);
    }

    public int bfs(int[][] grid){
        minObstacles[0][0] = 0;
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{0,0,0});
        while(!deque.isEmpty()){
            int[] curr = deque.remove();
            int obstacles = curr[0], row = curr[1], col = curr[2];
            for(int i=0; i<4; i++){
                int newRow = row + rowDirection[i];
                int newCol = col + colDirection[i];
                if(isVaid(newRow, newCol) && minObstacles[newRow][newCol]==Integer.MAX_VALUE){
                    //go and visit

                    //obstacle cell
                    if(grid[newRow][newCol]==1){
                        deque.addLast(new int[]{1+obstacles, newRow, newCol});
                        minObstacles[newRow][newCol] = obstacles;
                    }
                    else{
                        deque.addFirst(new int[]{obstacles, newRow, newCol});
                        minObstacles[newRow][newCol] = obstacles;
                    }
                }
            }
        }
        return minObstacles[grid.length-1][grid[0].length-1];
    }

    boolean isVaid(int row, int col){
        return row >= 0 && col >= 0 && row < minObstacles.length && col < minObstacles[0].length;
    }
}
