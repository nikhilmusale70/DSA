package Heaps;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        ConnectRopes obj = new ConnectRopes();
        System.out.println(obj.solve(A));
    }
    public int solve(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<A.length; i++){
            minHeap.add(A[i]);
        }

        //lets get the rope1 and rope2
        int rope1 = 0;
        int rope2 = 0;
        int ans=0;

        while(minHeap.size()>1){
            rope1 = minHeap.remove();
            rope2 = minHeap.remove();
            ans += rope1+rope2;

            //add rope1 and 2 back in minHeap
            minHeap.add(rope1+rope2);
        }

        return ans;
    }
}
