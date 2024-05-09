package DailyChallenge.May24;

import java.util.Collections;
import java.util.PriorityQueue;

public class May9_3075 {
    public static void main(String[] args) {
        int[] happiness = {1,2,3};
        int k = 2;
        May9_3075 obj = new May9_3075();
        System.out.println(obj.maximumHappinessSum(happiness, k));
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: happiness){
            maxHeap.add(num);
        }
        int decay = 0;
        int ans = 0;
        while(k>0){
            ans += maxHeap.remove()-decay;
            decay++;
            k--;
        }
        return ans;
    }
}
