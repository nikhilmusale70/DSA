package DailyChallenge.Jan24;

import java.util.*;

public class Jan14_1657 {
    public static void main(String[] args) {
        String a = "abc"; String b = "bca";
        Jan14_1657 obj = new Jan14_1657();
        System.out.println(obj.closeStrings(a, b));
    }
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        int[] freqMap1 = new int[26];
        int[] freqMap2 = new int[26];
        HashSet<Character> hs = new HashSet<>();

        for(char ch: word1.toCharArray()) {
            freqMap1[ch-'a']++;
            hs.add(ch);
        }
        for(char ch: word2.toCharArray()) {
            if(!hs.contains(ch)) return false;
            freqMap2[ch-'a']++;
        }

        Arrays.sort(freqMap1);
        Arrays.sort(freqMap2);

        return Arrays.equals(freqMap1, freqMap2);
    }
}
