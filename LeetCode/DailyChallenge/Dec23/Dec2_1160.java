package DailyChallenge.Dec23;

public class Dec2_1160 {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

        Dec2_1160 obj = new Dec2_1160();
        System.out.println(obj.countCharacters(words, chars));
    }
    public int countCharacters(String[] words, String chars) {
        int[] ch = new int[26];
        for(int i=0; i<chars.length(); i++){
            ch[chars.charAt(i)-'a']++;
        }

        int ans = 0;
        for(String str: words){
            if(checkIfPossible(ch.clone(), str)){
                ans += str.length();
            }
        }
        return ans;
    }

    boolean checkIfPossible(int[] ch, String str){
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            if(ch[curr-'a'] < 1){
                return false;
            }
            ch[curr-'a']--;
        }
        return true;
    }
}
