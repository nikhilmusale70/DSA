package DailyChallenge.Aug24;

import java.util.Arrays;
import java.util.Collections;

public class Aug6_3016 {
    public static void main(String[] args) {
        String word = "abcde";
        Aug6_3016 obj = new Aug6_3016();
        System.out.println(obj.minimumPushes(word));
    }

    public int minimumPushes(String word) {
        Integer[] chFreq = new Integer[26];
        Arrays.fill(chFreq, 0);

        for(char ch: word.toCharArray()){
            chFreq[ch-'a']++;
        }
        //we only have 8 digits
        Arrays.sort(chFreq, Collections.reverseOrder());
        int ans = 0;
        int digitUsed = 0;
        for(int freq: chFreq){
            ans += (digitUsed/8 + 1) * freq;
            digitUsed++;
        }
        return ans;
    }

}
