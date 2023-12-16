package DailyChallenge.Dec23;

public class Dec16_242 {
    public static void main(String[] args) {
        String s = "cat";
        String t = "rat";
        Dec16_242 obj = new Dec16_242();
        System.out.println(obj.isAnagram(s, t));
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }

        for(int curr: freq){
            if(curr!=0){
                return false;
            }
        }
        return true;
    }
}
