package DailyChallenge.May24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class May10_786 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k = 3;
        May10_786 obj = new May10_786();
        System.out.println(Arrays.toString(obj.kthSmallestPrimeFraction(arr, k)));
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));
        for(int i=0; i<arr.length; i++){
            minHeap.add(new double[]{((double) arr[i] /arr[arr.length-1]), i, arr.length-1});
        }
        while(k>1){
            double[] curr = minHeap.remove();
            int numerator = (int) curr[1];
            int denominator = (int) curr[2]-1;
            if(denominator>numerator){
                minHeap.add(new double[]{(double) arr[numerator]/arr[denominator], numerator, denominator});
            }
            k--;
        }
        double[] result = minHeap.remove();
        return new int[]{ arr[(int)result[1]], arr[(int) result[2]]};
    }
}
