package DailyChallenge.Nov;

public class nov24_1975 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        nov24_1975 obj = new nov24_1975();
        System.out.println(obj.maxMatrixSum(matrix));
    }
    public long maxMatrixSum(int[][] matrix) {
        int negatives=0;
        long ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]<0){
                    negatives++;
                }
                int curr = Math.abs(matrix[i][j]);
                min = Math.min(min, curr);
                ans += Math.abs(curr);
            }
        }
        if(negatives%2==1){
            //odd
            //1 number has to be -ve
            ans -= min* 2L;
        }
        return ans;
    }
}
