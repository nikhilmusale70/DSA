package DailyChallenge.June24;

public class June2_344 {
    public static void main(String[] args) {
        June2_344 obj = new June2_344();
        char[] s = {'h','e','l','l','o'};
        obj.reverseString(s);
    }
    public void reverseString(char[] s) {
        int start=0, end=s.length-1;
        while(start<=end){
            char temp = s[end];
            s[end]=s[start];
            s[start]=temp;
            end--;
            start++;
        }
    }
}
