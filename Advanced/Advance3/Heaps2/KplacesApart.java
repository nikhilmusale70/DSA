package Heaps2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KplacesApart {
    public static void main(String[] args) {
        int[] A  = {2, 1, 17, 10, 21, 95};
        int B = 1;
        KplacesApart obj = new KplacesApart();
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(obj.solve(A,B)));
    }

    public int[] solve(int[] A, int B) {
        int[] ans = new int[A.length];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<B; i++){
            minHeap.add(A[i]);
        }

        for (int i=0; i<A.length; i++){
            if(i+B<A.length)
                minHeap.add(A[i+B]);
            ans[i] = minHeap.remove();
        }

        return ans;
    }
}
