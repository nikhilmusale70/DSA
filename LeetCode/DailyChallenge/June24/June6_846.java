package DailyChallenge.June24;

import java.util.Arrays;
import java.util.HashMap;

public class June6_846 {
    public static void main(String[] args) {
        int[] hand = {8,1,2,3,6,2,3,4,7};
        int groupSize = 3;
        June6_846 obj = new June6_846();
        System.out.println(obj.isNStraightHand(hand, groupSize));
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        HashMap<Integer, Integer> deckOfCards = new HashMap<>();
        for(int num: hand){
            deckOfCards.put(num, deckOfCards.getOrDefault(num, 0)+1);
        }

        for(int card: hand){
            int start = card;
            while(deckOfCards.getOrDefault(start-1, 0)>0){
                start--;
            }

            while(start<=card){
                while (deckOfCards.get(start)>0) {
                    for (int currCard = start; currCard < start + groupSize; currCard++) {
                        if (deckOfCards.getOrDefault(currCard, 0) == 0) {
                            return false;
                        }
                        deckOfCards.put(currCard, deckOfCards.get(currCard) - 1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
