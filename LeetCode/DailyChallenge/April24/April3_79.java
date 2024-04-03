package DailyChallenge.April24;

public class April3_79 {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        April3_79 obj = new April3_79();
        System.out.println(obj.exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        int rows = board.length;
        int cols = board[0].length;
        int wordLength = wordArray.length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == wordArray[0] && backtrack(board, wordArray, visited, i, j, 0, rows, cols, wordLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] wordArray, boolean[][] visited, int row, int col, int pos, int rows, int cols, int wordLength) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || pos >= wordLength || board[row][col] != wordArray[pos]) {
            return false;
        }

        if (pos == wordLength - 1) {
            return true;
        }

        visited[row][col] = true;

        if (backtrack(board, wordArray, visited, row - 1, col, pos + 1, rows, cols, wordLength) ||
                backtrack(board, wordArray, visited, row, col + 1, pos + 1, rows, cols, wordLength) ||
                backtrack(board, wordArray, visited, row + 1, col, pos + 1, rows, cols, wordLength) ||
                backtrack(board, wordArray, visited, row, col - 1, pos + 1, rows, cols, wordLength)) {
            return true;
        }

        visited[row][col] = false;
        return false;
    }

}