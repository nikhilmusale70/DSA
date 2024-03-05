package DailyChallenge.March24;

public class March5_1750 {
    public static void main(String[] args) {
        String str = "cbcbc";
        March5_1750 obj = new March5_1750();
        System.out.println(obj.minimumLength(str));
    }

    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;
        // Traverse from both ends, removing identical characters
        while (start < end && s.charAt(start) == s.charAt(end)) {
            char currentChar = s.charAt(start);
            // Move start to the next different character
            while (start < s.length() && s.charAt(start) == currentChar) {
                start++;
            }
            // Move end to the previous different character
            while (end >= 0 && s.charAt(end) == currentChar) {
                end--;
            }
        }
        // Calculate the length after removal
        return (end < start) ? 0 : (end - start + 1);
    }

}
