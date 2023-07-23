package adv12Utils;

public class BuildPasactTriangle {
    public static void main(String[] args) {
        buildPascalTriangle(6,2,13);
    }
    public static int buildPascalTriangle(int n, int r, int mod) {
        r = Math.min(r, n-r);
        int[][] pascalTriangle = new int[n+1][n+1];

        for (int i=0; i<=n; i++){
            pascalTriangle[i][0]=1;
            pascalTriangle[i][i] = 1;
        }

        for (int i=1; i<=n; i++){
            for(int j=1; j<i; j++){
                pascalTriangle[i][j] = (pascalTriangle[i-1][j-1]%mod + pascalTriangle[i-1][j]%mod)%mod;
            }
        }
        return pascalTriangle[n][r];
    }
}
