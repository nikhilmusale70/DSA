package Heaps.Homework;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementIn2dArray {
    public static void main(String[] args) {
        int[][] A = {  {5, 9, 11},
                {9, 11, 13},
                {10, 12, 15},
                {13, 14, 16},
                {16, 20, 21} };
        int B = 12;
        KthSmallestElementIn2dArray obj = new KthSmallestElementIn2dArray();
        System.out.println(obj.solve(A,B));
    }
    public int solve(int[][] A, int B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //take 2d array into min heap
        for (int i=0; i<A.length; i++){
            for (int j=0; j<A[i].length; j++){
                if(maxHeap.size()<B){
                    maxHeap.add(A[i][j]);
                }
                else{
                    if(A[i][j]<maxHeap.peek()){
                        maxHeap.remove();
                        maxHeap.add(A[i][j]);
                    }
                }
            }
        }

        return maxHeap.peek();
    }
}
