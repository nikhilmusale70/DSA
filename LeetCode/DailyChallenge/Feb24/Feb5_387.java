package DailyChallenge.Feb24;

public class Feb5_387 {
    public static void main(String[] args) {
        String s = "leetcode";
        Feb5_387 obj = new Feb5_387();
        System.out.println(obj.firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
