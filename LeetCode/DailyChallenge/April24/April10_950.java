package DailyChallenge.April24;

import java.util.Arrays;

public class April10_950 {
    public static void main(String[] args) {
        April10_950 obj = new April10_950();
        int[] deck = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(obj.deckRevealedIncreasing(deck)));
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int[] ans = new int[deck.length];
        int idx = 0;
        int i =0;

        boolean skip = false;
        while(idx<deck.length){
            if(ans[i]==0){
                if(!skip){
                    ans[i] = deck[idx];
                    idx++;
                }
                skip = !skip;
            }
            i = (i+1)%deck.length;
        }
        return ans;
    }
}
