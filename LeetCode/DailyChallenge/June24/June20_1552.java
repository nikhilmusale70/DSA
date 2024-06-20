package DailyChallenge.June24;

import java.util.Arrays;

public class June20_1552 {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        June20_1552 obj = new June20_1552();
        System.out.println(obj.maxDistance(position, m));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int ans = 0;
        int low = 1;
        int high = (int) Math.ceil(position[position.length - 1] / (m - 1.0));

        while(low<=high){
            int mid = low + (high-low)/2;

            if(isPossible(mid, position, m)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    boolean isPossible(int space, int[] position, int m){
        int prevBall = position[0];
        int ballsPlaced = 1;

        for(int i=1; i<position.length && ballsPlaced<m; i++){
            int currPosition = position[i];
            if(currPosition - prevBall >= space){
                ballsPlaced++;
                prevBall = currPosition;
            }
        }
        return ballsPlaced==m;
    }
}
