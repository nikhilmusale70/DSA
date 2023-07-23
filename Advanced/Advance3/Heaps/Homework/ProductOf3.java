package Heaps.Homework;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ProductOf3 {
    public static void main(String[] args) {
        int [] A= {1, 2, 3, 4, 5};
        ProductOf3 obj = new ProductOf3();
        System.out.println(Arrays.toString(obj.solve(A)));
    }
    public int[] solve(int[] A) {
        int[] ans = new int[A.length];
        int product=1;
        //create a min heap for size 3
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0; i<3; i++){
            minHeap.add(A[i]);
            product *= A[i];
            ans[i] = i<2?-1: product;
        }

        //lets iterate over array now
        for(int i=3; i<A.length; i++){
            //check new element is more that min of heap
            //if yes insert, then calculate the  product accordingly
            if(A[i]>minHeap.peek()){
                int elementToRemove = minHeap.remove();
                minHeap.add(A[i]);
                product /= elementToRemove;
                product *= A[i];
                ans[i]=product;
            }
            else {
                ans[i] = product;
            }
        }
        return ans;
    }
}
