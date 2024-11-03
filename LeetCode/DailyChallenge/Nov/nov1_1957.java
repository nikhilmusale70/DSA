package DailyChallenge.Nov;

public class nov1_1957 {
    public static void main(String[] args) {
        String s = "aaabaaaa";
        nov1_1957 obj = new nov1_1957();
        System.out.println(obj.makeFancyString(s));
    }

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<=sb.length()-3; i++){
            if(sb.charAt(i) == sb.charAt(i+1) && sb.charAt(i+1) == sb.charAt(i+2)){
                sb.deleteCharAt(i);
                i--;
            }
        }
        return sb.toString();
    }
}
