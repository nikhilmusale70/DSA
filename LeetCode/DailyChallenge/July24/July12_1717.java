package DailyChallenge.July24;

import java.util.Stack;

public class July12_1717 {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;
        July12_1717 obj = new July12_1717();
        System.out.println(obj.maximumGain(s, x, y ));
    }
    int ans;
    public int maximumGain(String s, int x, int y) {
        ans = 0;
        if(x>y){
            s = removeAB(s, x);
            removeBA(s, y);
        }
        else{
            s = removeBA(s, y);
            removeAB(s, x);
        }
        return ans;
    }

    String removeAB(String s, int x){
        Stack<Character> stk = new Stack<>();
        for (char ch: s.toCharArray()){
            if(stk.isEmpty() || !(stk.peek()=='a' && ch=='b')){
                stk.push(ch);
            }
            else{
                stk.pop();
                ans+=x;
            }
        }
        return stackToString(stk);
    }

    String removeBA(String s, int y){
        Stack<Character> stk = new Stack<>();
        for (char ch: s.toCharArray()){
            if(stk.isEmpty() || !(stk.peek()=='b' && ch=='a')){
                stk.push(ch);
            }
            else{
                stk.pop();
                ans+=y;
            }
        }
        return stackToString(stk);
    }

    String stackToString(Stack<Character> stk){
        StringBuilder sb = new StringBuilder();
        while(!stk.empty()){
            sb.insert(0, stk.pop());
        }
        return sb.toString();
    }
}
