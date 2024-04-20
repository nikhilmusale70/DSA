package DailyChallenge.April24;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class April20_1992 {
    public static void main(String[] args) {
        April20_1992 obj = new April20_1992();
        int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
        System.out.println(Arrays.deepToString(obj.findFarmland(land)));
    }
    class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> ans = new ArrayList<>();

        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){
                if(land[i][j] == 1){
                    //farmLand
                    Pair pr = bfs(land, i, j);
                    ans.add(new int[]{i,j, pr.x, pr.y});
                    i=pr.x;
                    j=pr.y;
                }
            }
        }
        int[][] answer = new int[ans.size()][4];
        int i=0;
        for (int[] arr: ans){
            answer[i] = arr;
            i++;
        }
        return answer;
    }
    int[] xx = {-1, 0, 0, 1};
    int[] yy = {0, -1, 1, 0};
    Pair bfs(int[][] land, int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        Pair pr = q.peek();
        while(!q.isEmpty()){
            pr = q.remove();
            land[pr.x][pr.y] = 0;
            for(int i=0; i<4; i++){
                int newX = pr.x + xx[i];
                int newY = pr.y + yy[i];
                if(isValid(land, newX, newY)){
                    q.add(new Pair(newX, newY));
                }
            }
        }
        //we have right most index in pr
        return pr;
    }

    boolean isValid(int[][] land, int x, int y){
        if(x<0 || y<0 || x>=land.length || y>=land[0].length ){
            return false;
        }
        return land[x][y]==1;
    }

}
