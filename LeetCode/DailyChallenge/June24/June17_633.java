package DailyChallenge.June24;

import java.util.HashSet;

public class June17_633 {
    public static void main(String[] args) {
        int c = 2;
        June17_633 obj = new June17_633();
        System.out.println(obj.judgeSquareSum(c));
    }
    public boolean judgeSquareSum(int c) {
        int high = (int) Math.sqrt(c);
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<=high; i++){
            hs.add(i*i);
        }

        for(int i=0; i<=high; i++){
            int want = c-(i*i);
            if(hs.contains(want)){
                return true;
            }
        }
        return false;
    }
}
