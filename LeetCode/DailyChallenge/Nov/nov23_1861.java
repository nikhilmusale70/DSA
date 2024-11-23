package DailyChallenge.Nov;

import java.util.Arrays;

public class nov23_1861 {
    public static void main(String[] args) {
        char [][] box = {{'#','.','*','.'},
                {'#','#','*','.'}};

        nov23_1861 obj = new nov23_1861();
        System.out.println(Arrays.deepToString(obj.rotateTheBox(box)));
    }
    public char[][] rotateTheBox(char[][] box) {
        for(char[] row: box){
            for(int i=0; i<row.length; i++){
                //if stone is there, add it to empty place
                if(row[i] == '#'){
                    int j = i;
                    while(true){
                        //if empty space is there add our stone
                        if(row[j]=='.'){
                            row[j] = '#';
                            row[i] = '.';
                            break;
                        }
                        //if obstracle is there, that means no need to find on left
                        if(row[j]=='*'){
                            i = j;
                            break;
                        }
                        j++;
                    }
                }
            }
        }
        //2d array is done, now from m*n to n*m
        return rotate90Clockwise(box);
    }

    public char[][] rotate90Clockwise(char[][] matrix) {
        int m = matrix.length;        // Number of rows in original matrix
        int n = matrix[0].length;     // Number of columns in original matrix

        // New matrix with swapped dimensions
        char[][] rotated = new char[n][m];

        // Fill the new matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = (char) matrix[i][j];
            }
        }

        return rotated;
    }
}
