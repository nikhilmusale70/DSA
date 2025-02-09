package DailyChallenge.Feb25;

public class Feb5 {
    public static void main(String[] args) {
        String s1 = "bank", s2 = "kanb";
        Feb5 obj = new Feb5();
        System.out.println(obj.areAlmostEqual(s1, s2));
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int difference = 0;
        int firstDiff = 0;
        int secondDiff = 0;

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                difference++;
                if(difference>2) return false;
                else if(difference==1) firstDiff = i;
                else secondDiff = i;
            }
        }

        return s1.charAt(firstDiff) == s2.charAt(secondDiff) && s2.charAt(firstDiff) == s1.charAt(secondDiff);
    }
}
