package DailyChallenge.Dec23;

import java.util.Arrays;

public class Dec13_1582 {

    public static void main(String[] args) {
        int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
        Dec13_1582 obj = new Dec13_1582();
        int[] row = new int[mat.length];
        System.out.println(Arrays.stream(mat[0]).sum());
    }

}
