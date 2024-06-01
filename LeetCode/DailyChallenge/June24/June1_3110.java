package DailyChallenge.June24;

public class June1_3110 {
    public static void main(String[] args) {
        String s = "hello";
        June1_3110 obj = new June1_3110();
        System.out.println(obj.scoreOfString(s));
    }
    public int scoreOfString(String s) {
        char[] ch = s.toCharArray();

        int score = 0;
        for(int i=1; i<s.length(); i++){
            score += Math.abs(ch[i-1] - ch[i]);
        }
        return score;
    }
}
