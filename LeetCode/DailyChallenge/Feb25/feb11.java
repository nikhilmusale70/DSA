package DailyChallenge.Feb25;

public class feb11 {
    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        feb11 obj = new feb11();
        System.out.println(obj.removeOccurrences(s, part));
    }

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int m = part.length();
        for(int i=0; i<n; i++){
            sb.append(s.charAt(i));
            if(s.charAt(i)==part.charAt(m-1)){
                int lastIdx = sb.length()-1;
                int partIdx = m-1;
                while(lastIdx>=0 && partIdx>=0 && sb.charAt(lastIdx) == part.charAt(partIdx)){
                    lastIdx--;
                    partIdx--;
                }
                if(partIdx==-1){
                    sb.delete(sb.length()-m, sb.length());
                }
            }
        }
        return sb.toString();
    }
}
