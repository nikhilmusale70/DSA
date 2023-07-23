package Stacks2;

import java.util.Arrays;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        int[] A = {66, 96, 43, 28, 14, 1, 41, 76, 70, 81, 22, 11, 42, 78, 4, 88, 70, 43, 90, 6, 12};
        SortStack obj = new SortStack();
        System.out.println(Arrays.toString(obj.solve(A)));
    }
    public int[] solve(int[] A) {
        //lets create a stack to store original numbers
        Stack<Integer> original = new Stack<>();
        for (int i=0; i<A.length; i++){
            original.push(A[i]);
        }

        //using another stack to sort
        Stack<Integer> stk = new Stack<>();
        Integer temp = null;

        while(!original.isEmpty()){
             if(stk.isEmpty() || original.peek()<stk.peek()){
                 stk.push(original.pop());
             }
             else {
                 temp = original.pop();
                 while(!stk.isEmpty() && temp>stk.peek()){
                     original.push(stk.pop());
                 }
                 stk.push(temp);
             }

        }
        System.out.println("hello");
        System.out.println(stk);
        System.out.println(original);

        //stk contains sorted numbers
        for (int i=0; i<A.length; i++){
            A[i] = stk.pop();
        }
        return A;
    }
}
