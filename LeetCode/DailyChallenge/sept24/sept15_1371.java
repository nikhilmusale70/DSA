package DailyChallenge.sept24;

public class sept15_1371 {
    public static void main(String[] args) {
        String str = "leetcodeisgreat";
        sept15_1371 obj = new sept15_1371();
        System.out.println(obj.findTheLongestSubstring(str));
    }
    public int findTheLongestSubstring(String s) {
        int[] charCode = new int[26];
        charCode['a'-'a'] = 1;
        charCode['e'-'a'] = 2;
        charCode['i'-'a'] = 4;
        charCode['o'-'a'] = 8;
        charCode['u'-'a'] = 16;


        int[] preXor = new int[s.length()];
        preXor[0] = charCode[s.charAt(0)-'a'];
        for(int i=1; i<preXor.length; i++){
            preXor[i] = preXor[i-1] ^ charCode[s.charAt(i)-'a'];
        }

        return 0;


    }
}
