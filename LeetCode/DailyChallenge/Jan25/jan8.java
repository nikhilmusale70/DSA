package DailyChallenge.Jan25;

public class jan8 {
    public static void main(String[] args) {
        jan8 obj = new jan8();
        String[] words = {"abab","ab"};
        System.out.println(obj.countPrefixSuffixPairs(words));
    }
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (i != j && isValidPrefixSuffix(words[i], words[j])) {
                    ans++;
                }
            }
        }

        return ans;
    }

    boolean isValidPrefixSuffix(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // s1 must fit entirely at both prefix and suffix of s2
        if (n > m) return false;

        // Check prefix
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        // Check suffix
        for (int i = 0; i < n; i++) {
            if (s1.charAt(n - 1 - i) != s2.charAt(m - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
