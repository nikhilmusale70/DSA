package Stacks2;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestElem {
    public static void main(String[] args) {
        NearestSmallestElem obj = new NearestSmallestElem();
        int[] A = {39, 27, 11, 4, 24, 32, 32, 1};
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(obj.prevSmaller(A)));
    }

    public int[] prevSmaller(int[] A) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[A.length];
        for (int i=0; i<A.length; i++){
            while(!stk.isEmpty() && stk.peek()>=A[i]){
                stk.pop();
            }
            if (stk.isEmpty()){
                ans[i] = -1;
                stk.push(A[i]);
            }
            else{
                ans[i] = stk.peek();
                stk.push(A[i]);
            }
        }
        return ans;
    }
}
