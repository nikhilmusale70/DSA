package DailyChallenge.June24;

public class June21_1052 {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5},
                 grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;

        June21_1052 obj = new June21_1052();
        System.out.println(obj.maxSatisfied(customers, grumpy, minutes));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0, extraSatisfied = 0, maxExtraSatisfied = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) totalSatisfied += customers[i];
            else if (i < minutes) extraSatisfied += customers[i];
        }

        maxExtraSatisfied = extraSatisfied;

        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) extraSatisfied += customers[i];
            if (grumpy[i - minutes] == 1) extraSatisfied -= customers[i - minutes];
            maxExtraSatisfied = Math.max(maxExtraSatisfied, extraSatisfied);
        }

        return totalSatisfied + maxExtraSatisfied;
    }

}
