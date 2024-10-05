package DailyChallenge.oct24;

public class oct5_567 {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "dba";
        oct5_567 obj = new oct5_567();
        System.out.println(obj.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        char[] str1 = new char[26];
        for(char ch: s1.toCharArray()){
            str1[ch-'a']++;
        }

        //create a window with size as s1
        char[] str2 = new char[26];
        int idx;
        for(idx=0; idx<s1.length(); idx++){
            str2[s2.charAt(idx)-'a']++;
        }
        //window is create
        //idx is right pointer
        //left will be idx-s1.length
        while(idx<s2.length()){
            if(match(str1, str2)){
                return true;
            }

            str2[s2.charAt(idx)-'a']++;
            str2[s2.charAt(idx-s1.length())-'a']--;
            idx++;
        }


        return match(str1, str2);
    }

    boolean match(char[] str1, char[] str2){
        for(int i=0; i<str1.length; i++){
            if(str1[i] != str2[i]) return false;
        }
        return true;
    }
}
