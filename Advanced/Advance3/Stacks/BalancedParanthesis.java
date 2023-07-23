package Stacks;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String A = "{([])}";
        BalancedParanthesis obj = new BalancedParanthesis();
        System.out.println(obj.solve(A));
    }

    public int solve(String A) {
        Stack<Character> stk = new Stack<Character>();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)=='{' || A.charAt(i)=='(' || A.charAt(i)=='['){
                stk.push(A.charAt(i));
            }
            else{
                if(stk.isEmpty()){
                    return 0;
                }
                if( !((A.charAt(i)=='}' && stk.peek()=='{') ||  (A.charAt(i)==')' && stk.peek()=='(') || (A.charAt(i)==']' && stk.peek()=='[')) ){
                    return 0;
                }
                else{
                    stk.pop();
                }
            }
        }
        if(stk.isEmpty()){
            return 1;
        }
        else return 0;
    }

}
