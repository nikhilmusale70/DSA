package DailyChallenge.oct24;

import java.util.Comparator;
import java.util.PriorityQueue;

public class oct14_2530 {
    public static void main(String[] args) {
        int[] nums = {1,10,3,3,3};
        int k = 3;
        oct14_2530 obj = new oct14_2530();
        System.out.println(obj.maxKelements(nums, k));
    }
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: nums){
            maxHeap.add(num);
        }
        long ans = 0;
        while(k>0){
            int num = maxHeap.remove();
            ans += num;
            maxHeap.add((num+2)/3);
            k--;
        }
        return ans;
    }
}
