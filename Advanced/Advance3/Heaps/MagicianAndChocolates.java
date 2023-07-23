package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
    public static void main(String[] args) {
        int A = 5;
        int[] B = {2, 4, 6, 8, 10};
        MagicianAndChocolates obj = new MagicianAndChocolates();
        System.out.println(obj.nchoc(A, B));
    }

    public int nchoc(int A, int[] B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //lets add all the choclates in max heap
        for (int i=0; i<B.length; i++){
            maxHeap.add(B[i]);
        }

        //now kid will start eating and magician will start adding
        int maxChocoKidCanEat = 0;
        for (int i=0; i<A; i++){
            int temp = maxHeap.remove();
            maxHeap.add(temp/2);
            maxChocoKidCanEat += temp;
        }
        return maxChocoKidCanEat;
    }
}
