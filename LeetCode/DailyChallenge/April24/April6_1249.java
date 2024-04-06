package DailyChallenge.April24;

public class April6_1249 {
    public static void main(String[] args) {
        String s = "(a(b(c)d)";
        April6_1249 obj = new April6_1249();
        System.out.println(obj.minRemoveToMakeValid(s));
    }
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for(char ch: s.toCharArray()){
            if(ch=='(') open++;
            else if(ch == ')'){
                if(open>close) close++;
            }
        }
        open = close;
        //we have close amount of pair;

        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray()){
            if(ch=='('){
                if(open>0){
                    sb.append(ch);
                    open--;
                }
            }
            else if(ch==')'){
                if(open<close){
                    sb.append(ch);
                    close--;
                }
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
