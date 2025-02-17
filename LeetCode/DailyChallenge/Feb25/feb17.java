package DailyChallenge.Feb25;

import java.util.HashSet;
import java.util.Set;

public class feb17 {
    public static void main(String[] args) {
        String tiles = "AAB";
        feb17 obj = new feb17();
        System.out.println(obj.numTilePossibilities(tiles));
    }

    public int numTilePossibilities(String tiles) {
        Set<String> sequence = new HashSet<>();
        boolean[] bool = new boolean[tiles.length()];
        for(int i=0; i<tiles.length(); i++){
            findSequence("", bool, tiles, sequence);
        }
        return sequence.size()-1;
    }

    void findSequence(String curr, boolean[] bool, String tiles, Set<String> sequence){
        sequence.add(curr);
        for(int i=0; i<tiles.length(); i++){
            if(!bool[i]){
                bool[i] = true;
                findSequence(curr+tiles.charAt(i), bool, tiles, sequence);
                bool[i] = false;
            }
        }
    }
}
