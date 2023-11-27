package DailyChallenge.Nov23;

public class Nov27_935 {
    public static void main(String[] args) {
        Nov27_935 obj = new Nov27_935();
        System.out.println(obj.knightDialer(3131));
    }
    int[][] keyPad;
    int[][][] dp;
    public int knightDialer(int n) {
        keyPad = new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        dp = new int[keyPad.length][4][n+1];

        //lets keep horse one by one at every number;

        int ans =  0;
        for(int x=0; x<keyPad.length; x++){
            for(int y=0; y<3; y++){
                ans = (ans + numberPossible(x, y, n-1))% 1_000_000_007;
            }
        }
        return ans;
    }

    int[] row = {1, -1,  1, -1, -2, -2,  2, 2};
    int[] col = {2,  2, -2, -2, -1,  1, -1, 1};


    int numberPossible(int x, int y, int n){
        if(!checkIfValid(x,y)){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[x][y][n]!=0){
            return dp[x][y][n];
        }

        int ans =0;
        for(int i=0; i<row.length; i++){
            int dx = row[i] + x;
            int dy = col[i] + y;
            if(checkIfValid(dx, dy)){
                ans = (ans + numberPossible(dx, dy, n-1))% 1_000_000_007;
            }
        }
        return dp[x][y][n] = ans;
    }

    boolean checkIfValid(int x, int y){
        if(x<0 || y<0 || x>=keyPad.length || y>=3 || keyPad[x][y]==-1){
            return false;
        }
        return true;
    }
}
