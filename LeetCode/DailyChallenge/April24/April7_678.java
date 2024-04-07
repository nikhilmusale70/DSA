package DailyChallenge.April24;

import java.util.Arrays;

public class April7_678 {
    public static void main(String[] args) {
        String s = "(*))";
        April7_678 obj = new April7_678();

        System.out.println(obj.checkValidString(s));
    }

    public boolean checkValidString(String s) {
        int openMin = 0;
        int openMax = 0;

        for(char ch: s.toCharArray()){
            if(ch==')'){
                openMax--;
                openMin--;
            }
            else if(ch=='('){
                openMin++;
                openMax++;
            }
            else{
                openMin--;
                openMax++;
            }
            if(openMax<0) return false;
            openMin = Math.max(0, openMin);
        }
        return openMin==0;
    }
}
