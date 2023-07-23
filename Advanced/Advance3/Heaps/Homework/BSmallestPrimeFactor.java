package Heaps.Homework;


import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BSmallestPrimeFactor {

    public static void main(String[] args) {
        int [] A = {1,2,3,5};
        int B = 3;
        BSmallestPrimeFactor obj = new BSmallestPrimeFactor();
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(obj.solve(A, B)));
    }


    public int[] solve(int[] A, int B) {
        HashMap<Double, int[]> hm = new HashMap<>();

        PriorityQueue<Double> minHeap = new PriorityQueue<>();

        for(int j=0; j<A.length-1; j++){
            int[] tempArr = new int[]{j, A.length-1};
            double fraction = (A[j]*1.0) / (A[A.length-1]);
            hm.put(fraction, tempArr);
            minHeap.add(fraction);
        }


        for(int i=0; i<B-1; i++){
            double removedElement = minHeap.remove();
            int numeratorIndex = hm.get(removedElement)[0];
            int denominatorIndex = hm.get(removedElement)[1];

            hm.remove(removedElement);

//            System.out.println("NumIndex: " + numeratorIndex + " DenoIdx: " + denominatorIndex);

            if(numeratorIndex<denominatorIndex) {
//                System.out.println(A[numeratorIndex] + " " + A[denominatorIndex-1]);
                double fraction = A[numeratorIndex] * 1.0 / A[denominatorIndex - 1];
                minHeap.add(fraction);
                hm.put(fraction, new int[]{numeratorIndex, denominatorIndex - 1});
            }
        }

        double bthElem = minHeap.remove();
        return new int[]{A[hm.get(bthElem)[0]], A[hm.get(bthElem)[1]]};
    }
}

