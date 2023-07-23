package Stacks2.Homework;

import Stacks2.NearestSmallestElem;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterElement {
    public static void main(String[] args) {
        NearestGreaterElement obj = new NearestGreaterElement();
        int[] A = {39, 27, 11, 4, 24, 32, 32, 1 };
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(obj.nextGreater(A)));
    }

    public int[] nextGreater(int[] A) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[A.length];

        for (int i=A.length-1; i>=0; i--){
            while(!stk.isEmpty() && stk.peek()<=A[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                ans[i] = -1;
                stk.push(A[i]);
            }
            else {
                ans[i] = stk.peek();
                stk.push(A[i]);
            }
        }
        return ans;
    }
}
