package DailyChallenge.May24;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class May8_506 {
    public static void main(String[] args) {
        int[] score = {5,4,3,2,1};
        May8_506 obj = new May8_506();
        System.out.println(Arrays.toString(obj.findRelativeRanks(score)));
    }
    public String[] findRelativeRanks(int[] score) {
        int max = Integer.MIN_VALUE;
        for(int sc: score){
            max = Math.max(sc, max);
        }

        int[] totalRanks = new int[max+1];
        for(int i=0; i<score.length; i++){
            totalRanks[score[i]] = i+1;
        }

        int rank = 1;
        String[] ran = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] ans = new String[score.length];
        for(int i=max; i>=0; i--){
            if(totalRanks[i]!=0){
                if(rank<4){
                    ans[totalRanks[i]-1] = ran[rank-1];
                }
                else{
                    ans[totalRanks[i]-1] = rank+"";
                }
                rank++;
            }
        }
        return ans;
    }
}
