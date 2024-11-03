package DailyChallenge.Nov;

public class nov3_796 {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        nov3_796 obj = new nov3_796();
        System.out.println(obj.rotateString(s, goal));
    }
    public boolean rotateString(String s, String goal) {
        s = s + s;
        for(int i=0; i<s.length(); i++){
            int j=0;
            while(s.charAt(i)==goal.charAt(j)){
                i++; j++;
                if(j==goal.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
