package DailyChallenge.Dec24;

import java.util.PriorityQueue;

public class dec13_2593 {
    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5,2};
        dec13_2593 obj = new dec13_2593();
        System.out.println(obj.findScore(nums));
    }
    public long findScore(int[] nums) {
        long ans = 0;
        boolean[] visited = new boolean[nums.length];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a1, a2) -> {
           if(a1[0]==a2[0]) return a1[1]-a2[1];
           return a1[0] - a2[0];
        });
        for(int i=0; i<nums.length; i++){
            minHeap.add(new int[]{nums[i], i});
        }

        while(!minHeap.isEmpty()){
            int[] temp = minHeap.remove();
            int num = temp[0];
            int idx = temp[1];
            if (!visited[idx]){
                //go and visit
                ans += num;
                if(idx>0) visited[idx-1]=true;
                if(idx<nums.length-1) visited[idx+1]=true;
            }
        }
        return ans;
    }
}
