package DailyChallenge.June24;

import java.util.Arrays;
import java.util.List;

public class June7_648 {
    public static void main(String[] args) {
        List<String> dictionary = List.of("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";

        June7_648 obj = new June7_648();
        System.out.println(obj.replaceWords(dictionary, sentence));
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        for(int i=0; i<words.length; i++){
            words[i] = checkIfReplace(words[i], dictionary);
        }
        return String.join(" ", words);
    }

    String checkIfReplace(String str, List<String> dictionary){
        String ans = str;
        for(String root: dictionary){
            int i=0;
            while(i<root.length() && i<ans.length() && str.charAt(i)==root.charAt(i)){
                i++;
            }
            if(i==root.length()){
                ans = ans.length()>root.length()?root:ans;
            }
        }
        return ans;
    }
}
