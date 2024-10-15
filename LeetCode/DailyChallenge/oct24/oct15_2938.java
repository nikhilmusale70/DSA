package DailyChallenge.oct24;

public class oct15_2938 {
    public static void main(String[] args) {
        String s = "00101";
        oct15_2938 obj = new oct15_2938();
        System.out.println(obj.minimumSteps(s));
    }
    public long minimumSteps(String s) {
        int idx = 0;
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                ans += i-idx;
                idx++;
            }
        }
        return ans;
    }
}
