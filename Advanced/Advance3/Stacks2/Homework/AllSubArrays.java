package Stacks2.Homework;

import java.util.Arrays;
import java.util.OptionalLong;
import java.util.Stack;

public class AllSubArrays {
    public static void main(String[] args) {
        AllSubArrays obj = new AllSubArrays();
        //7569780 and 9066928 16373956
        int[] A = {7569780, 6509094, 9066928, 9978215, 9990289, 500953, 5829073, 2862108, 2983492, 8356802}; //16373956
        System.out.println(obj.solve(A));
    }
    public int solve(int[] A) {
        int ans = 0;

        Stack<Integer> stk = new Stack<>();
        stk.push(0);

        for (int i=1; i<A.length; i++){
            while(!stk.isEmpty()){
                ans = Math.max(ans, A[i]^A[stk.peek()]);
                if(A[stk.peek()]>A[i]){
                    break;
                }
                stk.pop();
            }
            stk.push(i);
        }

        return ans;
    }
}
