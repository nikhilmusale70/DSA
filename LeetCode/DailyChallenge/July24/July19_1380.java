package DailyChallenge.July24;

import java.util.*;

public class July19_1380 {
    public static void main(String[] args) {
        int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        July19_1380 obj = new July19_1380();
        System.out.println(obj.luckyNumbers(matrix));
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        Set<Integer> minRowValues = new HashSet<>();

        // Collect minimum values from each row
        for (int[] row : matrix) {
            minRowValues.add(Arrays.stream(row).min().getAsInt());
        }

        // Check if the maximum values in each column are in the set of minimum row values
        for (int c = 0; c < matrix[0].length; c++) {
            int max = Integer.MIN_VALUE;
            for (int[] row : matrix) {
                max = Math.max(max, row[c]);
            }
            if (minRowValues.contains(max)) {
                luckyNumbers.add(max);
            }
        }

        return luckyNumbers;
    }


}
