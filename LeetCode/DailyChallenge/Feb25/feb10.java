package DailyChallenge.Feb25;

public class feb10 {
    public static void main(String[] args) {
        String s = "cb34";
        feb10 obj = new feb10();
        System.out.println(obj.clearDigits(s));
    }
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
