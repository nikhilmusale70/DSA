package String.HomeWork;

public class StringOperation {
    public String solve(String A) {
        String str = A + A;
        String result ="";
        for(char ch: A.toCharArray()){
            if(Character.isUpperCase(ch)){

            }
            else if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                result += '#';
            }
            else{
                result += ch;
            }
        }

        return result;
    }
}
