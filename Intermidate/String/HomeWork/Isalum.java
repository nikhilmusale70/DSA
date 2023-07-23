package String.HomeWork;

public class Isalum {
    public static void main(String[] args) {

    }

    public int solve(char[] A) {
        for(char ch:A){
            if (!((ch>64 && ch<=90) || (ch>96&&ch<=122) || (ch>47&&ch<=57))){
                return 0;
            }
        }
        return 1;
    }
}
