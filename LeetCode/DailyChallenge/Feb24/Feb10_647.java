package DailyChallenge.Feb24;

import java.util.Arrays;

public class Feb10_647 {
    public static void main(String[] args) {
        String str = "aaa";
        Feb10_647 obj = new Feb10_647();
        System.out.println(obj.countSubstrings(str));
    }

    public int countSubstrings(String A) {
        int count=0;
        int[][]dp = new int[A.length()][A.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        for (int i=0; i<A.length(); i++){
            for (int j=i; j<A.length(); j++){
                if(isPalin(A, i, j, dp)==1){
                    count++;
                }
            }
        }
        return count;
    }
    int isPalin(String str, int i, int j, int[][] dp){
        if(i>=j) return 1;
        if (dp[i][j]!=-1) return dp[i][j];

        return (str.charAt(i)==str.charAt(j) && isPalin(str, i+1, j-1, dp)==1)?1:0;
    }
}
