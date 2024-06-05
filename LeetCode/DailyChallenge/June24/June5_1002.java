package DailyChallenge.June24;

import java.util.ArrayList;
import java.util.List;

public class June5_1002 {
    public static void main(String[] args) {
        June5_1002 obj = new June5_1002();
        String[] words = {"bella","label","roller"};
        System.out.println(obj.commonChars(words));
    }
    public List<String> commonChars(String[] words) {
        int[] freq;
        int[] freq2;

        freq = getFreqArray(words[0]);

        for(int i=1; i<words.length; i++){
            freq2 = getFreqArray(words[i]);
            for(int j=0; j<26; j++){
                freq[j] = Math.min(freq[j], freq2[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i=0; i<26; i++){
            while(freq[i]>0) {
                ans.add(String.valueOf((char) ('a' + i)));
                freq[i]--;
            }

        }
        return ans;
    }
    int[] getFreqArray(String word){
        int[] freq = new int[26];
        for(int i=0; i<word.length(); i++){
            freq[word.charAt(i)-'a']+=1;
        }
        return freq;
    }
}
