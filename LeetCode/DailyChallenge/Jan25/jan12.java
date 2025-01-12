package DailyChallenge.Jan25;

import java.util.Stack;

public class jan12 {
    public static void main(String[] args) {
        String s = "))()))", locked = "010100";
        jan12 obj = new jan12();
        System.out.println(obj.canBeValid(s, locked));
    }

    public boolean canBeValid(String s, String locked) {
        if (s.length()%2==1) return false;

        Stack<Integer> fixed = new Stack<>();
        Stack<Integer> wildCard = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(locked.charAt(i)=='0'){
                //wild card
                wildCard.push(i);
            }
            else{
                if(s.charAt(i)=='('){
                    fixed.push(i);
                }
                else{
                    //need to pop
                    if(fixed.isEmpty() && wildCard.isEmpty()){
                        return false;
                    }
                    if(!fixed.isEmpty()){
                        fixed.pop();
                    }
                    else {
                        wildCard.pop();
                    }
                }
            }
        }

        if(fixed.size()>wildCard.size()) return false;

        while (!fixed.isEmpty()){
            int fix = fixed.pop();
            int free = wildCard.pop();
            if(fix>free) return false;
        }
        return true;
    }
}
