package DailyChallenge.May24;

public class May13_861 {
    public static void main(String[] args) {
//        int[][] grid = {{0},{1}};
        int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        May13_861 obj = new May13_861();
        System.out.println(obj.matrixScore(grid));
    }
    public int matrixScore(int[][] grid) {
        // Flip rows if needed to maximize score
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][0] == 0) {
                flipRow(grid, row);
            }
        }

        int power = grid[0].length - 1;
        int score = (int) (grid.length * Math.pow(2, power));
        power--;

        // Calculate the score for each column
        for (int col = 1; col < grid[0].length; col++) {
            int count1 = countOnes(grid, col);
            int count0 = grid.length - count1;
            score += (int) (Math.max(count0, count1) * Math.pow(2, power));
            power--;
        }

        return score;
    }

    // Helper function to flip a row
    private void flipRow(int[][] grid, int row) {
        for (int col = 0; col < grid[0].length; col++) {
            grid[row][col] = (grid[row][col] == 1) ? 0 : 1;
        }
    }

    // Helper function to count ones in a column
    private int countOnes(int[][] grid, int col) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][col] == 1) {
                count++;
            }
        }
        return count;
    }
}
