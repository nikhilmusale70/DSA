package DailyChallenge.Jan25;

import java.util.ArrayList;
import java.util.List;

public class jan11 {
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"}, words2 = {"oe","o"};
        jan11 obj = new jan11();
        System.out.println(obj.wordSubsets(words1,words2));
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Calculate the maximum frequency of each letter across all words in words2
        int[] maxFreqWords2 = new int[26];
        for (String word : words2) {
            int[] freq = getFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreqWords2[i] = Math.max(maxFreqWords2[i], freq[i]);
            }
        }

        // Find all universal words in words1
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = getFrequency(word);
            if (isUniversal(freq, maxFreqWords2)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper method to calculate the frequency of each letter in a word
    private int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Helper method to check if a word satisfies the universal condition
    private boolean isUniversal(int[] freq1, int[] maxFreq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] < maxFreq2[i]) {
                return false;
            }
        }
        return true;
    }

}
