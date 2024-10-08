package DailyChallenge.oct24;

public class oct8_1963 {
    public static void main(String[] args) {
        String s = "]]][[[";
        oct8_1963 obj = new oct8_1963();
        System.out.println(obj.minSwaps(s));
    }
    public int minSwaps(String s) {
        int openBracket = 0;
        int imbalance = 0;
        for(char ch: s.toCharArray()){
            if(ch=='[') openBracket++;
            else if(openBracket==0){
                imbalance++;
            }
            else openBracket--;
        }
        return (imbalance+1)/2;
    }
}
