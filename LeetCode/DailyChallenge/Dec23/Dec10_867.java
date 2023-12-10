package DailyChallenge.Dec23;

public class Dec10_867 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Dec10_867 obj = new Dec10_867();
        System.out.println(obj.transpose(matrix));
    }

    public int[][] transpose(int[][] matrix) {
        int[][] newMat = new int[matrix[0].length][matrix.length];

        for(int i=0; i<matrix[0].length; i++){
            for(int j=0; j<matrix.length; j++){
                newMat[i][j] = matrix[j][i];
            }
        }
        return newMat;
    }
}
