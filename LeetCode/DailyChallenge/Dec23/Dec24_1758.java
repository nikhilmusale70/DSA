package DailyChallenge.Dec23;

import java.util.HashSet;
import java.util.Set;

public class Dec24_1758 {
    public static void main(String[] args) {
        Dec24_1758 obj = new Dec24_1758();
        String str = "1111";
        System.out.println(obj.minOperations(str));
//        Set<int> hs = new HashSet<>()
    }

    public int minOperations(String s) {
        char ch = s.charAt(0);
        int startWith0 = count(s, '0');
        int startWith1 = count(s, '1');
        return Math.min(startWith0, startWith1);
    }

    int count(String str, char pre){
        int count= pre==str.charAt(0)?0:1;
        for(int i=1; i<str.length(); i++){
            if(pre==str.charAt(i)){
                count++;
            }
            pre = pre=='1'?'0':'1';
        }
        return count;
    }
}
