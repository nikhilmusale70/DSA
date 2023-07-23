package Heaps2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        int[] A = {59, 64, 10, 39};
        RunningMedian obj = new RunningMedian();
        System.out.println(Arrays.toString(obj.solve(A)));
    }

    public int[] solve(int[] A) {
        //stream flow from A
        //keep smaller numbers left side and larger number right side
        //also use max heap and min heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int[] ans = new int[A.length];

        //lets first insert number into right(in max heap)
        maxHeap.add(A[0]);
        ans[0]=maxHeap.peek();

        //lets create a strem now
        for(int i=1; i<A.length; i++){
            if(maxHeap.peek()<=A[i]){
                minHeap.add(A[i]);
                //check that the size also doesn't gets mismatched
                if(minHeap.size()>maxHeap.size()){
                    //send from min heap to maxHeap
                    int elementToSend = minHeap.remove();
                    maxHeap.add(elementToSend);
                }
            }
            else{
                maxHeap.add(A[i]);
                if(maxHeap.size()>minHeap.size()+1){
                    //max heap is greater, so now we will shift from lmax to min
                    int elementToSend = maxHeap.remove();
                    minHeap.add(elementToSend);
                }
            }
            System.out.println(maxHeap);
            ans[i] = maxHeap.peek();

        }
        return ans;
    }
}
