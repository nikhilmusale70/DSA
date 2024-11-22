package DailyChallenge.Nov;

import java.util.Arrays;
import java.util.HashMap;

public class nov22_1072 {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,0,1},{1,1,0}};
        nov22_1072 obj = new nov22_1072();
        System.out.println(obj.maxEqualRowsAfterFlips(matrix));
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> hm = new HashMap<>();
        int ans = 0;
        for(int[] row: matrix){
            StringBuilder sb = new StringBuilder();
            for (int num : row) {
                sb.append(num); // Custom delimiter
            }

            if(row[0]==1) {
                for(int i=0; i<sb.length(); i++){
                    if(sb.charAt(i)=='0') sb.replace(i,  i+1, "1");
                    else sb.replace(i,  i+1, "0");
                }
            }

            String str = sb.toString();

            hm.put(str, hm.getOrDefault(str, 0)+1);

            ans = Math.max(ans, hm.get(str));
        }
        return ans;
    }
}
