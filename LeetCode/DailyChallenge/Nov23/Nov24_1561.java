package DailyChallenge.Nov23;

import java.util.Arrays;

public class Nov24_1561 {
    public static void main(String[] args) {
        int nums[] = {9,8,7,6,5,1,2,3,4};
        Nov24_1561 obj = new Nov24_1561();
        System.out.println(obj.maxCoins(nums));
    }
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int i=0; int j=piles.length-1;
        while(i<j){
            ans += piles[j-1];
            j -= 2;
            i++;
        }
        return ans;
    }
}
