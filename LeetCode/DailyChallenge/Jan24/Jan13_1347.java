package DailyChallenge.Jan24;

public class Jan13_1347 {
    public static void main(String[] args) {
        String  s = "leetcode", t = "practice";
        Jan13_1347 obj = new Jan13_1347();
        System.out.println(obj.minSteps(s, t));
    }
    public int minSteps(String s, String t) {
        int[] character = new int[26];
        for(char ch: s.toCharArray()){
            character[ch-'a']++;
        }

        int ans = 0;
        for(char ch: t.toCharArray()){
            if(character[ch-'a']<=0){
                ans++;
            }
            character[ch-'a']--;
        }
        return ans;
    }
}
