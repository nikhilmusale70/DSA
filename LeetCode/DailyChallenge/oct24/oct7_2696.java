package DailyChallenge.oct24;

import java.util.Stack;

public class oct7_2696 {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        oct7_2696 obj = new oct7_2696();
        System.out.println(obj.minLength(s));
    }
    public int minLength(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='B' && !stk.empty() && stk.peek()=='A'){
                stk.pop();
            }
            else if(ch=='D' && !stk.empty() && stk.peek()=='C'){
                stk.pop();
            }
            else{
                stk.push(ch);
            }
        }
        return stk.size();
    }
}
