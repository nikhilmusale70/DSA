package DailyChallenge.Jan25;

public class jan9 {
    public static void main(String[] args) {
        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";
        jan9 obj = new jan9();
        System.out.println(obj.prefixCount(words, pref));
    }
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(String curr: words){
            if(curr.startsWith(pref)){
                ans++;
            }
        }
        return ans;
    }
}
