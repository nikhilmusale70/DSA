package Queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingQueue {
    public static void main(String[] args) {
        ReversingQueue obj = new ReversingQueue();
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
        System.out.println(Arrays.toString(obj.solve(A,B)));
    }
    public int[] solve(int[] A, int B) {
        Queue<Integer>  q = new LinkedList<>();
        for (int i: A){
            q.add(i);
        }

        Stack<Integer> stk = new Stack<>();
        for (int i=0; i<B; i++){
            stk.push(q.remove());
        }

        for (int i=0; i<A.length; i++){
            if(!stk.isEmpty()){
                A[i] = stk.pop();
            }
            else{
                A[i] = q.remove();
            }
        }
        return A;
    }
}
