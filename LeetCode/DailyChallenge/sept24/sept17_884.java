package DailyChallenge.sept24;

import java.util.*;

public class sept17_884 {
    public static void main(String[] args) {
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        sept17_884 obj = new sept17_884();
        System.out.println(Arrays.toString(obj.uncommonFromSentences(s1, s2)));
    }
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> words = new HashMap<>();
        for(String str: s1.split("\\s")){
            words.put(str, words.getOrDefault(str, 0) + 1);
        }
        for(String str: s2.split("\\s")){
            words.put(str, words.getOrDefault(str, 0) + 1);
        }

        List<String> ans = new ArrayList<>();
        //iternate on map
        for(Map.Entry<String, Integer> entry: words.entrySet()){
            if(entry.getValue()==1){
                ans.add(entry.getKey());
            }
        }

        return ans.toArray(new String[0]);
    }
}
