package DailyChallenge.June24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class June18_826 {
    public static void main(String[] args) {
        int[] difficulty = {2 ,4 ,6 ,8 ,10},
                  profit = {10,20,30,40,50},
                  worker = {4 ,5 ,6 ,7};
        June18_826 obj = new June18_826();
        System.out.println(obj.maxProfitAssignment(difficulty, profit, worker));
    }
    class Pair{
        int difficulty;
        int profit;

        public Pair(int profit, int difficulty) {
            this.profit = profit;
            this.difficulty = difficulty;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxWorker = Arrays.stream(worker).max().getAsInt();
        int[] jobs = new int[maxWorker+1];
        for(int i=0; i<difficulty.length; i++){
            if(difficulty[i]<=maxWorker)
                jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
        }
        for(int i=1; i<=maxWorker; i++){
            jobs[i] = Math.max(jobs[i], jobs[i-1]);
        }

        int totalProfit = 0;
        for(int currWorker: worker){
            totalProfit += jobs[currWorker];
        }
        return totalProfit;
    }
}
