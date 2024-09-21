package DailyChallenge.sept24;

import java.util.ArrayList;
import java.util.List;

public class sept21_386 {
    public static void main(String[] args) {
        int n = 13;
        sept21_386 obj = new sept21_386();
        System.out.println(obj.lexicalOrder(n));
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int currentNumber = 1;

        for (int i = 0; i < n; i++) {
            result.add(currentNumber);

            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10;
                }
                currentNumber++;
            }
        }

        return result;
    }

}
