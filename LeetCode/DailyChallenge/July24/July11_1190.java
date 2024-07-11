package DailyChallenge.July24;

import java.util.Stack;

public class July11_1190 {
    public static void main(String[] args) {
        String s = "(u(love)i)";
        July11_1190 obj = new July11_1190();
        System.out.println(obj.reverseParentheses(s));
    }
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[s.length()];

        // Find pairs of parentheses and store them in the array
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int openIndex = stack.pop();
                pair[i] = openIndex;
                pair[openIndex] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int curr = 0, direction = 1; curr < s.length(); curr += direction) {
            if (s.charAt(curr) == '(' || s.charAt(curr) == ')') {
                curr = pair[curr];
                direction = -direction;
            } else {
                result.append(s.charAt(curr));
            }
        }

        return result.toString();
    }
}
