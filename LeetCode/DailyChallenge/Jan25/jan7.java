package DailyChallenge.Jan25;

import java.util.ArrayList;
import java.util.List;

public class jan7 {
    public static void main(String[] args) {
        String[] words = {"mass","as","hero","superhero"};
        jan7 obj =  new jan7();
        System.out.println(obj.stringMatching(words));
    }

    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words.length; j++){
                if(i==j) continue;
                if(words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
