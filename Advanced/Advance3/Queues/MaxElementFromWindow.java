package Queues;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxElementFromWindow {
    public static void main(String[] args) {
        MaxElementFromWindow obj = new MaxElementFromWindow();

        int[] A = {167, 340, 869, 869, 609, 809, 529, 715, 34, 13, 657, 407, 684, 801, 129, 952};
        int B = 6;
        System.out.println(Arrays.toString(obj.slidingMaximum(A,B)));
    }

    public int[] slidingMaximum(final int[] A, int B) {
        int[] ans = new int[A.length - B +1];
        Deque<Integer> dq = new LinkedList<>();

        System.out.println(Arrays.toString(A));
        for (int i=0; i<B; i++){
            while(!dq.isEmpty() && dq.getLast()<A[i]){
                dq.removeLast();
            }
            dq.add(A[i]);
        }
        System.out.println(dq);
        ans[0]=dq.peek();
        System.out.println(dq);
        for (int i=B; i<A.length; i++){
            //remove first
            if(dq.peek()==A[i-B]){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && dq.getLast()<A[i]){
                dq.removeLast();
            }

            dq.add(A[i]);
            ans[i-B+1] = dq.peek();
        }
        return ans;
    }
}
