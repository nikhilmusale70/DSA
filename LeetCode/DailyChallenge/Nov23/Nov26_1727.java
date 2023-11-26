package DailyChallenge.Nov23;

import java.util.Arrays;

public class Nov26_1727 {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,1},{1,1,1},{1,0,1}};
        Nov26_1727 obj = new Nov26_1727();
        System.out.println(obj.largestSubmatrix(matrix));
    }

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }

            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, currRow[i] * (n - i));
            }
        }

        return ans;
    }
}
