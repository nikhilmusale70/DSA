package Heaps.Homework;

import Tries2.MaxXor;

import java.util.PriorityQueue;

public class MaxSumAfterBNegations {
    public static void main(String[] args) {
        int[] A = {24, -68, -29, -9, 84};
        int B = 4;
        MaxSumAfterBNegations obj = new MaxSumAfterBNegations();
        System.out.println(obj.solve(A, B));
    }
    public int solve(int[] A, int B) {
        //construct 2 min heap
        PriorityQueue<Integer> positiveMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> negativeMinHeap = new PriorityQueue<>();

        //put the numbers in respective heaps;
        for (int i : A){
            if(i>=0)
                positiveMinHeap.add(i);
            else
                negativeMinHeap.add(i);
        }

        //we have b operations so we will send elements from negative to positive heap
        //if we have extra operations then move from +ve to -ve
        for (int i=0; i<B; i++){
            if(negativeMinHeap.size()>0){
                positiveMinHeap.add(negativeMinHeap.remove()*-1);
            }
            else{
                int howManyOperationsRemaning = B-i;
                if (howManyOperationsRemaning%2==0){

                }
                else{
                    negativeMinHeap.add(positiveMinHeap.remove() * -1);
                }
                break;
            }
        }

        long ans=0;
        //start adding

        while(positiveMinHeap.size()>0){
            ans += positiveMinHeap.remove();
        }
        while(negativeMinHeap.size()>0){
            ans+= negativeMinHeap.remove();
        }

        return (int)ans;
    }
}
