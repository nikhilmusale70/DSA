package DailyChallenge.Jan24;

import java.util.Stack;

public class Jan30_150 {
    public static void main(String[] args) {
        String[] token = {"4","13","5","/","+"};
        Jan30_150 obj = new Jan30_150();
        System.out.println(obj.evalRPN(token));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String ch: tokens){
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){
                //get 2 elements from top of stack
                int second = stk.pop();
                int first = stk.pop();
                stk.push(doMath(first, second, ch));
                continue;
            }
            stk.push(Integer.valueOf(ch));
        }
        return stk.peek();
    }

    int doMath(int first, int second, String operation){
        if(operation.equals("+")){
            return first+second;
        }
        else if(operation.equals("-")){
            return first-second;
        }
        else if(operation.equals("*")){
            return first*second;
        }
        else {
            if(second==0) return 0;
            return first/second;
        }
    }
}
