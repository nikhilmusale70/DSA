package DailyChallenge.Jan25;

import java.util.Arrays;

public class jan6 {
    public static void main(String[] args) {
        String boxes = "001011";
        jan6 obj = new jan6();
        System.out.println(Arrays.toString(obj.minOperations(boxes)));
    }

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        //left to right
        int move = 0;
        int balls = 0;
        for(int i=0; i<n; i++){
            ans[i] = move + balls;
            move += balls;
            if(boxes.charAt(i)=='1') balls++;
        }

        //right to left
        move = 0;
        balls = 0;
        for(int i=n-1; i>=0; i--){
            ans[i] += move + balls;
            move += balls;
            if(boxes.charAt(i)=='1') balls++;
        }

        return ans;
    }
}
