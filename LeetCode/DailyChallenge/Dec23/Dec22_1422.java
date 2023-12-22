package DailyChallenge.Dec23;

public class Dec22_1422 {
    public static void main(String[] args) {
        Dec22_1422 obj = new Dec22_1422();
        System.out.println(obj.maxScore("00011"));
    }
    public int maxScore(String s) {
        int ans =0;
        int left=0;
        int right = 0;

        for(char ch: s.toCharArray()){
            if(ch == '1') right++;
        }

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == '0') left++;
            else right--;

            ans = Math.max(ans, left+right);
        }

        return ans;
    }
}
