package DailyChallenge.Dec23;

import Utils.ScaUtils;

public class Dec19_661 {
    public static void main(String[] args) {
        Dec19_661 obj = new Dec19_661();
        int[][] img = {{100,200,100},{200,50,200},{100,200,100}};
        ScaUtils.print2dArray(obj.imageSmoother(img));
    }

    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        for(int i=0; i<img.length; i++){
            for(int j=0; j<img[0].length; j++){
                ans[i][j] = getAverage(i, j, img);
            }
        }
        return ans;
    }
    int getAverage(int x, int y, int[][] img){
        int[] row = {0,  0, 0, 1, -1, -1, -1, 1, 1 };
        int[] col = {0, -1, 1, 0,  0, -1,  1, 1, -1};
        int ans = 0;
        int surroundings = 0;
        for(int i=0; i<row.length; i++){
            int currX = row[i]+x;
            int currY = col[i]+y;
            if(isValid(currX,currY,img.length,img[0].length)){
                surroundings++;
                ans += img[currX][currY];
            }
        }
        return ans/surroundings;
    }

    boolean isValid(int x, int y, int m, int n){
        if(x<0 || y<0 || x>=m || y>=n){
            return false;
        }
        return true;
    }
}
