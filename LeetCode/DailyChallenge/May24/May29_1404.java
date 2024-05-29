package DailyChallenge.May24;

public class May29_1404 {
    public static void main(String[] args) {
        String s = "1101";
        May29_1404 obj = new May29_1404();
        System.out.println(obj.numSteps(s));
    }

    public int numSteps(String s) {
        int N = s.length();

        int operations = 0;
        int carry = 0;
        for (int i = N - 1; i > 0; i--) {
            int digit = s.charAt(i) - '0' + carry;

            if (digit % 2 == 1) {
                operations += 2;
                carry = 1;
            } else {
                operations++;
            }
        }

        return operations + carry;
    }
}
