package Stacks.Homework;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        RedundantBraces obj = new RedundantBraces();
        String  A = "((a+b))";
        System.out.println(obj.braces(A));
    }

    public int braces(String A) {
        Stack<Character> global = new Stack<>();
        char local = '+';

        for (int i=0; i<A.length(); i++){
            if(A.charAt(i)=='('){
                global.push(local);
            }
            else if(A.charAt(i)==')'){
                global.pop();
            }
            else{

            }
        }

        return 0;
    }
}
