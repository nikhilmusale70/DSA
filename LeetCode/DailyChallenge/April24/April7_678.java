package DailyChallenge.April24;

import java.util.Arrays;

public class April7_678 {
    public static void main(String[] args) {
        String s = "(*))";
        April7_678 obj = new April7_678();

        System.out.println(obj.checkValidString(s));
    }

    int[][] dp;
    public boolean checkValidString(String s) {
        dp = new int[s.length()+1][s.length()+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        return checkString(s, 0, 0) == 1;
    }
    int checkString(String s, int idx, int open){
        if(s.length() == idx) return open==0?1:0;
        if(open<0) return 0;
        if(dp[idx][open] != -1) return dp[idx][open];

        if(s.charAt(idx) == '*'){
            if(checkString(s, idx+1, open+1)==1 || checkString(s, idx+1, open-1)==1 || checkString(s, idx+1, open)==1){
                return dp[idx][open] = 1;
            }
        }

        else if(s.charAt(idx) == ')'){
            return dp[idx][open] = checkString(s, idx+1, open-1);
        }
        else{
            return dp[idx][open] = checkString(s, idx+1, open+1);
        }
        return dp[idx][open] = 0;
    }
}
