package DailyChallenge.Feb25;

import java.util.*;

public class feb13 {
    public static void main(String[] args) {
        int[] nums = {999999999,999999999,999999999};
        int k = 1000000000;
        feb13 obj = new feb13();
        System.out.println(obj.minOperations(nums, k));
    }

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int num: nums){
            minHeap.add((long) num);
        }
        int ans = 0;
        while(!minHeap.isEmpty() && minHeap.peek()<k) {
            Long min = minHeap.remove();
            Long second = minHeap.remove();
            long toAdd = min*2 + second;
            minHeap.add(toAdd);
            ans++;
        }
        return ans;
    }
}
