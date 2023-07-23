package Stacks;

import LL2SortingAndDetectingLoop.DoublyLIst;

import java.util.Stack;

public class DoubleCharacterTrouble {
    public static void main(String[] args) {
        String A = "abccbc";
        DoubleCharacterTrouble obj = new DoubleCharacterTrouble();
        System.out.println(obj.solve(A));
    }
    public String solve(String A) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<A.length(); i++){
            if(!stk.isEmpty() && A.charAt(i)==stk.peek()){
                stk.pop();
            }
            else{
                stk.push(A.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!stk.isEmpty()){
            ans.append(stk.pop());
        }
        return ans.reverse().toString();
    }
}
