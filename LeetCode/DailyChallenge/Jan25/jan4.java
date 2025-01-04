package DailyChallenge.Jan25;

import java.util.HashSet;
import java.util.Set;

public class jan4 {
    public static void main(String[] args) {
        jan4 obj = new jan4();
        String s = "bbcbaba";
        System.out.println(obj.countPalindromicSubsequence(s));
    }

    public int countPalindromicSubsequence(String s) {
        int[] left = new int[26];
        int[] right = new int[26];

        // Fill the `right` array with the frequency of each character except the first
        for (int i = 1; i < s.length(); i++) {
            right[s.charAt(i) - 'a']++;
        }

        Set<String> hs = new HashSet<>();
        left[s.charAt(0) - 'a']++;

        // Iterate through the string, treating each character as the middle character
        for (int i = 1; i < s.length() - 1; i++) {
            char mid = s.charAt(i);
            right[mid - 'a']--;

            // Check for valid palindromic subsequences of the form `a + mid`
            for (int j = 0; j < 26; j++) {
                if (left[j] > 0 && right[j] > 0) {
                    hs.add("" + (char)(j + 'a') + mid);
                }
            }

            left[mid - 'a']++;
        }

        return hs.size();
    }

}
