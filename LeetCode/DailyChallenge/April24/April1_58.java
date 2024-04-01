package DailyChallenge.April24;

public class April1_58 {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        April1_58 obj = new April1_58();
        System.out.println(obj.lengthOfLastWord(s));
    }
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;

        // Trim trailing spaces
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        // Count length of last word
        int length = 0;
        while (end >= 0 && s.charAt(end) != ' ') {
            length++;
            end--;
        }

        return length;
    }

}
