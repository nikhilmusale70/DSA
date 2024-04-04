package DailyChallenge.April24;

public class April4_1614 {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        April4_1614 obj = new April4_1614();
        System.out.println(obj.maxDepth(s));
    }

    public int maxDepth(String s) {
        int count = 0;
        int maxNum = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (maxNum < count)
                    maxNum = count;
            } else if (c == ')') {
                count--;
            }
        }
        return maxNum;
    }
}
