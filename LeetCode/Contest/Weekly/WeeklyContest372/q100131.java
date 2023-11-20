package Contest.Weekly.WeeklyContest372;

public class q100131 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "aabc";
        String s3 = "a";
        q100131 obj = new q100131();
        System.out.println(obj.findMinimumOperations(s1, s2, s3));
    }
    public int findMinimumOperations(String s1, String s2, String s3) {
        int pointer = 0;
        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        //lets find comonality
        while(pointer<minLen && s1.charAt(pointer) == s2.charAt(pointer) && s2.charAt(pointer) == s3.charAt(pointer)){
            pointer++;
        }
        if(pointer == s1.length() && s1.length()==s2.length() && s3.length() == pointer){
            return 0;
        }
        if(pointer<1){
            return -1;
        }
        int ans = s1.length()<pointer? 0 : s1.length()-pointer;
        ans += s2.length()<pointer? 0 : s2.length()-pointer;
        ans += s3.length()<pointer? 0 : s3.length()-pointer;
        return ans;
    }
}
