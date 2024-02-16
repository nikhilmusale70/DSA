package DailyChallenge.Feb24;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Feb16_1481 {
    public static void main(String[] args) {
        Feb16_1481 obj = new Feb16_1481();
        int[] arr = {4,3,1,1,3,3,2};
        int k = 2;
        System.out.println(obj.findLeastNumOfUniqueInts(arr, k));
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Create a HashMap to store the frequency of each integer in the array.
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: arr){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Create a PriorityQueue (minHeap) to store the frequencies of integers.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(hm.values());

        // Iterate through the minHeap, removing integers until k is exhausted or minHeap is empty.
        while(!minHeap.isEmpty() && k > 0 && minHeap.peek() <= k) {
            // If the frequency of the smallest integer in minHeap is less than or equal to k,
            // remove it from the minHeap and subtract its frequency from k.
            k -= minHeap.peek();
            minHeap.remove();
        }

        // The size of minHeap at this point represents the minimum number of unique integers
        // that need to be removed to satisfy the conditions.
        return minHeap.size();
    }
}
