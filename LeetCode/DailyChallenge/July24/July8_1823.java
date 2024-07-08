package DailyChallenge.July24;

import java.util.LinkedList;
import java.util.Queue;

public class July8_1823 {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        July8_1823 obj = new July8_1823();
        System.out.println(obj.findTheWinner(n,k));
    }

    public int findTheWinner(int n, int k) {
        Queue<Integer> circle = new LinkedList<>();

        // Initialize the queue with people numbered from 1 to n
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // Process until only one person is left in the circle
        while (circle.size() > 1) {
            // Move the first k-1 people to the end of the queue
            for (int i = 0; i < k - 1; i++) {
                circle.add(circle.remove());
            }
            // Remove the k-th person from the circle
            circle.remove();
        }

        // Return the last remaining person
        return circle.remove();
    }


}
