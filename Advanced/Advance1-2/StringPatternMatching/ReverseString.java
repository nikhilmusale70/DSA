package StringPatternMatching;

public class ReverseString {
    public static void main(String[] args) {
        String A ="crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ";
        ReverseString obj = new ReverseString();
        System.out.println(obj.solve(A));
    }
    public String solve(String A) {
        String B="";
        int begin=A.length()-1, end=A.length();
        //remove trailing space from back
        for (int i=A.length()-1; i>=0; i--){
            if (A.charAt(i)!=' '){
                A = A.substring(0, i+1);
                break;
            }
        }
        for(int i=A.length()-1; i>=0; i--){
            if(A.charAt(i)==' ' || i==0){
                if (i==0)
                    begin--;
                B += A.substring(begin, end) + " ";
                end = i;
            }
            else{
                begin = i;
            }
        }
        B = B.substring(0, B.length()-1);
        return B;
    }
}
