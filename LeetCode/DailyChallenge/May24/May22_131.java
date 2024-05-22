package DailyChallenge.May24;

import java.util.ArrayList;
import java.util.List;

public class May22_131 {
    public static void main(String[] args) {
        String s = "aab";
        May22_131 obj = new May22_131();
        System.out.println(obj.partition(s));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s, start, end - 1)) {
                path.add(s.substring(start, end));
                backtrack(s, end, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
