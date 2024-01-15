package DailyChallenge.Jan24;

import java.util.*;

public class Jan15_2225 {
    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        Jan15_2225 obj = new Jan15_2225();
        System.out.println(obj.findWinners(matches));
    }
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100001];
        for(int[] arr: matches){
            int winner = arr[0];
            int loser = arr[1];

            if(losses[winner]==0) losses[winner] = -1;
            if(losses[loser]==-1){
                losses[loser] = 1;
            }
            else{
                losses[loser]++;
            }
        }
        List<Integer> winner = new ArrayList<>();
        List<Integer> runnerUp = new ArrayList<>();

        for(int i=1; i<losses.length; i++){
            if(losses[i]==-1){
                winner.add(i);
            }
            if(losses[i]==1){
                runnerUp.add(i);
            }
        }
        return new ArrayList<>(Arrays.asList(winner, runnerUp));
    }
}
