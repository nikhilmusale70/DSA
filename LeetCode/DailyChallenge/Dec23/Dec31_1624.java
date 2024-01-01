package DailyChallenge.Dec23;

import java.util.Arrays;

public class Dec31_1624 {
    public static void main(String[] args) {
        Dec31_1624 obj = new Dec31_1624();
        System.out.println(obj.maxLengthBetweenEqualCharacters("aa"));
    }
     int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        int[] ch = new int[26];
        Arrays.fill(ch, -1);
        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if(ch[idx] == -1){
                ch[idx] = i;
            }
            else{
                max = Math.max(max, i- ch[idx] -1);
            }
        }
        return max;
    }
}
