package DailyChallenge.Dec23;

public class Dec13_1582 {

    public static void main(String[] args) {
        int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
        Dec13_1582 obj = new Dec13_1582();
        System.out.println(obj.numSpecial(mat));
    }
    public int numSpecial(int[][] mat) {
        int ans=0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j]==1 && checkIfPossible(i, j, mat)){
                    ans++;
                }
            }
        }
        return ans;
    }
    boolean checkIfPossible(int row, int col, int[][] mat){
        for(int i=0; i<mat[row].length; i++){
            if(mat[row][i]==1 && col!=i){
                return false;
            }
        }
        for(int j=0; j<mat.length; j++){
            if(mat[j][col]==1 && row!=j){
                return false;
            }
        }
        return true;
    }
}
