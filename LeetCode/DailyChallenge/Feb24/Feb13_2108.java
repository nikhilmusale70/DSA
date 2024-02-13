package DailyChallenge.Feb24;

public class Feb13_2108 {
    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        Feb13_2108 obj = new Feb13_2108();
        System.out.println(obj.firstPalindrome(words));
    }

    public String firstPalindrome(String[] words) {
        for(String str: words){
            if(isPalindrome(str)){
                return str;
            }
        }
        return "";
    }

    boolean isPalindrome(String str){
        int left = 0, right = str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
