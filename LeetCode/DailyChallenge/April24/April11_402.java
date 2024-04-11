package DailyChallenge.April24;

import java.net.Inet4Address;
import java.util.Stack;

public class April11_402 {
    public static void main(String[] args) {
        String num = "10200";
        int k=1;
        April11_402 obj = new April11_402();
        System.out.println(obj.removeKdigits(num, k));
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        for(char ch: num.toCharArray()){
            while(!stk.isEmpty() && ch<stk.peek() && k>0){
                stk.pop();
                k--;
            }
            stk.push(ch);
        }
        while(k>0){
            k--;
            stk.pop();
        }

        StringBuilder ans = new StringBuilder();
        while(!stk.isEmpty()){
            ans.insert(0, stk.pop());
        }

        while (!ans.isEmpty() && ans.charAt(0)=='0'){
            ans.deleteCharAt(0);
        }
        return ans.length()>0?ans.toString():"0";
    }
}
