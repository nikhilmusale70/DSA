package DailyChallenge.July24;

import java.util.Stack;

public class July10_1598 {
    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","./","d3/","../","d31/"};
        July10_1598 obj = new July10_1598();
        System.out.println(obj.minOperations(logs));
    }

    public int minOperations(String[] logs) {
        int depth = 0;
        for (String str: logs){
            if (str.equals("../")){
                depth--;
            }
            else if(!str.equals("./")){
                depth++;
            }
            depth = Math.max(0, depth);
        }
        return depth;
    }
}
