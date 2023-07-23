package Stacks;

import java.util.HashSet;
import java.util.Stack;

public class PostfixOperation {
    public static void main(String[] args) {
        String[] A = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        PostfixOperation obj = new PostfixOperation();
        System.out.println(obj.evalRPN(A));
    }
    public int evalRPN(String[] A) {
        HashSet<String> hs = new HashSet<>();
        hs.add("+");
        hs.add("-");
        hs.add("/");
        hs.add("*");

        Stack<Integer> stk = new Stack<>();
        for (int i=0; i<A.length; i++){
            if( !stk.isEmpty() && hs.contains(A[i]) ){
                int first = stk.pop();
                int second = stk.pop();
                int ans = doCal(first, second, A[i]);
                stk.push(ans);
            }
            else
                stk.push(Integer.parseInt(A[i]));
        }

        return stk.peek();
    }

    int doCal(int second, int first, String sym){
        int ans =0;
        if (sym.equals("-")){
            ans = first - second;
        }
        else if (sym.equals("+")){
            ans = first + second;
        }
        else if (sym.equals("*")){
            ans = first * second;
        }
        else {
            ans = first / second;
        }
        return ans;
    }
}
