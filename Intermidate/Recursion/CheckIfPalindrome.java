package Recursion;

public class CheckIfPalindrome {
    public static void main(String[] args) {
        System.out.println(solve("naman"));
    }
    public static int solve(String A) {
        if(isPalindrome(0, A.length()-1, A)){
            return 1;
        }
        return 0;
    }

    public static boolean isPalindrome(int s, int e, String str){
        if(s>e){
            return true;
        }
        else{
            if (str.charAt(s) != str.charAt(e)){
                return false;
            }
            else{
                return isPalindrome(s+1, e-1, str);
            }
        }
    }
}
