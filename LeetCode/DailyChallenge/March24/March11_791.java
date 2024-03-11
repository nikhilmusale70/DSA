package DailyChallenge.March24;

public class March11_791 {
    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        March11_791 obj = new March11_791();
        System.out.println(obj.customSortString(order, s));
    }

    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: order.toCharArray()){
            while(freq[ch-'a']>0){
                sb.append(ch);
                freq[ch-'a']--;
            }
        }

        for(int i=0; i<26; i++){
            while(freq[i]>0){
                sb.append(Character.toString(i+'a'));
                freq[i]--;
            }
        }

        return sb.toString();
    }
}
