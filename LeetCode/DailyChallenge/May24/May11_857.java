package DailyChallenge.May24;

import Structural.Decorator.PizzaDecorator;

import java.util.*;

public class May11_857 {
    public static void main(String[] args) {
        int[] quality = {3,1,10,10,1};
        int [] wage = {4,8,2,2,7};
        int k = 3;
        May11_857 obj = new May11_857();
        System.out.println(obj.mincostToHireWorkers(quality, wage, k));
    }
    public static class Pair{
        double ratio;
        int idx;

        public Pair(double ratio, int idx) {
            this.ratio = ratio;
            this.idx = idx;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        List<Pair> workers = new ArrayList<>();
        for(int i=0; i<wage.length; i++){
            workers.add(new Pair((double) wage[i] /quality[i], i));
        }
        workers.sort(Comparator.comparingDouble(a -> a.ratio));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int team = 0;
        for (int i=0; i<k; i++){
            int currWorkerQuality = quality[workers.get(i).idx];
            maxHeap.add(currWorkerQuality);
            team += currWorkerQuality;
        }
        double ans = team*workers.get(k-1).ratio;

        for(int lead=k; lead< wage.length; lead++){
            double leadsRatio = workers.get(lead).ratio;
            int currWorkerQuality = quality[workers.get(lead).idx];

            if (!maxHeap.isEmpty() && maxHeap.peek()>currWorkerQuality){
                team = team - maxHeap.peek() + currWorkerQuality;
                maxHeap.remove();
                maxHeap.add(currWorkerQuality);
            }

            double captainTeamsRatio = leadsRatio * team;
            ans = Math.min(ans, captainTeamsRatio);
        }
        return ans;
    }
}
