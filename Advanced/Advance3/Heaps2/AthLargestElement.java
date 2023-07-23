package Heaps2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AthLargestElement {
    public static void main(String[] args) {
        AthLargestElement obj = new AthLargestElement();
        int[] B= {1, 2, 3, 4, 5, 6};
        int A = 4;
        System.out.println(Arrays.toString(obj.solve(A,B)));
    }

    public int[] solve(int A, int[] B) {
        //create min heap of A size()
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i=0; i<A; i++){
            minHeap.add(B[i]);
        }

        int[] ans = new int[B.length];

        for (int i=0; i<B.length; i++){
            if(i<A-1) {
                ans[i] = -1;
                continue;
            }

            if(i>=A && minHeap.peek()<B[i]){
                minHeap.add(B[i]);
                minHeap.remove();
            }
            ans[i] = minHeap.peek();
        }
        return ans;
    }
}
