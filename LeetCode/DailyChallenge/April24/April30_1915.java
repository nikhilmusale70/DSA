package DailyChallenge.April24;

import java.util.HashMap;
import java.util.Map;

public class April30_1915 {
    public static void main(String[] args) {
        String word = "aba";
        April30_1915 obj = new April30_1915();
        System.out.println(obj.wonderfulSubstrings(word));
    }
    public long wonderfulSubstrings(String word) {
        int N = word.length();

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int mask = 0;
        long res = 0L;

        // Iterate through each character of the word
        for (int i = 0; i < N; i++) {
            char c = word.charAt(i);
            int bit = c - 'a';

            // Flip the parity of the bit representing the current character in the running prefix mask
            mask ^= (1 << bit);

            // Count smaller prefixes that create substrings with no odd occurring letters
            res += freq.getOrDefault(mask, 0);

            // Increment the frequency associated with the current mask by 1
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);

            // Loop through every possible letter that can appear an odd number of times in a substring
            // ch represents character form A to J
            for (int ch = 0; ch < 10; ch++) {
                res += freq.getOrDefault(mask ^ (1 << ch), 0);
            }
        }

        // Return the total count of wonderful substrings
        return res;
    }


}
