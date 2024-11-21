package DailyChallenge.Nov;

public class nov21_2257 {
    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}}, walls = {{0, 1}, {2, 2}, {1, 4}};
        nov21_2257 obj = new nov21_2257();
        System.out.println(obj.countUnguarded(m, n, guards, walls));
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];

        // Mark walls
        for (int[] wall : walls) {
            matrix[wall[0]][wall[1]] = 2; // Mark as wall
        }

        // Mark guards
        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = 1; // Mark as guard
        }

        // Traverse for each guard
        for (int[] guard : guards) {
            bfs(guard[0], guard[1], matrix);
        }

        // Count unguarded cells
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    void bfs(int x, int y, int[][] matrix) {
        // Move up
        int tempX = x, tempY = y;
        while (--tempY >= 0) {
            if (isNotValid(tempX, tempY, matrix.length, matrix[0].length) || matrix[tempX][tempY] == 2 || matrix[tempX][tempY] == 1) break;
            if (matrix[tempX][tempY] == 0) matrix[tempX][tempY] = 3;
        }

        // Move down
        tempY = y;
        while (++tempY < matrix[0].length) {
            if (isNotValid(tempX, tempY, matrix.length, matrix[0].length) || matrix[tempX][tempY] == 2 || matrix[tempX][tempY] == 1) break;
            if (matrix[tempX][tempY] == 0) matrix[tempX][tempY] = 3;
        }

        // Move right
        tempX = x;
        tempY = y;
        while (++tempX < matrix.length) {
            if (isNotValid(tempX, tempY, matrix.length, matrix[0].length) || matrix[tempX][tempY] == 2 || matrix[tempX][tempY] == 1) break;
            if (matrix[tempX][tempY] == 0) matrix[tempX][tempY] = 3;
        }

        // Move left
        tempX = x;
        while (--tempX >= 0) {
            if (isNotValid(tempX, tempY, matrix.length, matrix[0].length) || matrix[tempX][tempY] == 2 || matrix[tempX][tempY] == 1) break;
            if (matrix[tempX][tempY] == 0) matrix[tempX][tempY] = 3;
        }
    }

    boolean isNotValid(int x, int y, int m, int n) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }

}
