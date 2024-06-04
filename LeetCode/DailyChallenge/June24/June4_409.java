package DailyChallenge.June24;

import java.util.HashMap;
import java.util.Map;

public class June4_409 {
    public static void main(String[] args) {
        June4_409 obj = new June4_409();

        String s = "abccccdd";
        System.out.println(obj.longestPalindrome(s));
    }

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = 0;

        for(char ch: s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
            if(hm.get(ch)==2){
                ans +=2;
                hm.remove(ch);
            }
        }
        if(!hm.isEmpty()) ans+=1;

        return ans;
    }
}
