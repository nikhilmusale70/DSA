package DailyChallenge.Jan24;

import java.util.HashMap;
import java.util.Map;

public class Jan12_1704 {
    public static void main(String[] args) {
        String str = "AbCdEfGh";
        Jan12_1704 obj = new Jan12_1704();
        System.out.println(obj.halvesAreAlike(str));
    }
    public boolean halvesAreAlike(String s) {
        int vowelCount = 0;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);

            if(curr == 'A' || curr == 'E' || curr=='I' || curr=='O' || curr=='U' || curr == 'a' || curr == 'e' || curr=='i' || curr=='o' || curr=='u'){
                if(i<s.length()/2){
                    vowelCount++;
                }
                else{
                    vowelCount--;
                    if(vowelCount<0) return false;
                }
            }
        }
        return vowelCount == 0;
    }
}
