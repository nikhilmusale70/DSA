package DailyChallenge.May24;

import java.util.*;

public class May15_2812 {
    public static void main(String[] args) {
        May15_2812 obj = new May15_2812();
        int[][] matrix = {{0,0,0,1},{0,0,0,0},{0,0,0,0},{1,0,0,0}};

        List<List<Integer>> grid = new ArrayList<>();

        for (int[] row : matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int value : row) {
                list.add(value);
            }
            grid.add(list);
        }
        System.out.println(obj.maximumSafenessFactor(grid));
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] safeGrid = safetyGrid(grid);
        return dijKstra(safeGrid);
    }

    int dijKstra(int[][] safeGrid){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[2]-a[2]);
        pq.add(new int[]{0,0,safeGrid[0][0]});
        safeGrid[0][0] = -1;

        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            if(curr[0]==safeGrid.length-1 && curr[1]==safeGrid[0].length-1){
                return curr[2];
            }

            //now try to see all the 4 paths
            for(int i=0; i<4; i++){
                int newX = curr[0]+x[i];
                int newY = curr[1]+y[i];
                if(checkValid(newX, newY, safeGrid.length) && safeGrid[newX][newY]!=-1){
                    pq.add(new int[]{newX, newY, Math.min(curr[2], safeGrid[newX][newY])});
                    safeGrid[newX][newY] = -1;
                }
            }
        }
        return 0;
    }

    int[] x = {-1, 0, 0, 1};
    int[] y = {0, -1, 1, 0};

    int[][] safetyGrid(List<List<Integer>> grid){
        int[][] safeGrid = new int[grid.size()][grid.getFirst().size()];
        for(int[] row: safeGrid){
            Arrays.fill(row, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int row=0; row<grid.size(); row++){
            for(int col=0; col< grid.getFirst().size(); col++){
                if(grid.get(row).get(col)==1){
                    //we have got the thief
                    safeGrid[row][col] = 0;
                    q.add(new int[]{row, col, 0});
                }
            }
        }

        //BFS traversal
        while(!q.isEmpty()){
            int[] curr = q.remove();
            //curr[0]->x || curr[1]->y || curr[2]->safety factor of x, y
            for(int i=0; i<4; i++){
                int newX = curr[0]+x[i];
                int newY = curr[1]+y[i];
                if(checkValid(newX, newY, grid.size()) && safeGrid[newX][newY]==-1) {
                    safeGrid[newX][newY] = curr[2] + 1;
                    q.add(new int[]{newX, newY, curr[2] + 1});
                }
            }
        }
        return safeGrid;
    }

    boolean checkValid(int x, int y, int n){
        return x >= 0 && y >= 0 && x < n && y < n;
    }

}
