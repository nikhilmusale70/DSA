package DailyChallenge.Dec23;

import java.util.Arrays;

public class Dec29_1335 {
    public static void main(String[] args) {
        int[] jobDifficulty = {6,5,4,3,2,1};
        int d = 2;
        Dec29_1335 obj = new Dec29_1335();

        System.out.println(obj.minDifficulty(jobDifficulty, d));
    }

    public int minDifficulty(int[] jobDifficulty, int days) {
        if(jobDifficulty.length<days) return -1;

        int difficulty = Arrays.stream(jobDifficulty).sum();
        if(difficulty==0) return 0;
        if(jobDifficulty.length == days) return difficulty;

        return helper(jobDifficulty, days, 0);
    }

    int helper(int[] jobDifficulty, int daysLeft, int idx){
        int jobs = jobDifficulty.length;
        if(daysLeft==1){
            int max = jobDifficulty[idx];
            for(int i=idx; i<jobs; i++){
                max = Math.max(max, jobDifficulty[i]);
            }
            return max;
        }

        int currentDifficulty = Integer.MIN_VALUE;
        daysLeft--;
        int maxJobsWeCanConsider = jobs - idx - daysLeft + 1;

        int result = Integer.MAX_VALUE;
        for(int i=1; i<maxJobsWeCanConsider; i++){
            currentDifficulty = Math.max(currentDifficulty, jobDifficulty[idx+i-1]);
            int otherMax = helper(jobDifficulty, daysLeft-1, idx+i);
            result = Math.min(result, currentDifficulty + otherMax);
        }
        return result;
    }
}
