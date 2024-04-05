package DailyChallenge.April24;
public class April5_1544 {
    public static void main(String[] args) {
        String s = "QkqMGmQKq";
        April5_1544 obj = new April5_1544();
        System.out.println(obj.makeGood(s));
    }
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (char curr : s.toCharArray()) {
            char peek = (sb.length() > 0) ? sb.charAt(sb.length() - 1) : '1';
            if (Math.abs(peek - curr) == 32 && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }
}
