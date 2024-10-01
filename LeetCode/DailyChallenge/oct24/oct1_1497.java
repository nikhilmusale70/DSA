package DailyChallenge.oct24;

import java.util.HashMap;

public class oct1_1497 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        oct1_1497 obj = new oct1_1497();
        System.out.println(obj.canArrange(arr, k));
    }

    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int numOfPairs = 0;
        for (int num : arr) {
            int rem = (num % k + k) % k;
            int weWant = (k - rem) % k;

            if (hm.getOrDefault(weWant, 0) > 0) {
                // If we have the "weWant" remainder available, reduce its count
                numOfPairs++;
                hm.put(weWant, hm.get(weWant) - 1);
            } else {
                // increase the count of the current remainder
                hm.put(rem, hm.getOrDefault(rem, 0) + 1);
            }
        }

        // Check if all pairs have been made
        return numOfPairs==arr.length/2;
    }

}
