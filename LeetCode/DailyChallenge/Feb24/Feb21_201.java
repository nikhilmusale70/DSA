package DailyChallenge.Feb24;

public class Feb21_201 {
    public static void main(String[] args) {
        Feb21_201 obj = new Feb21_201();
        int left = 6;
        int right = 7;
        System.out.println(obj.rangeBitwiseAnd(left, right));
    }
    public int rangeBitwiseAnd(int left, int right) {
        int shiftCount = 0;

        // Find the common prefix (left == right) by right shifting both left and right until they are equal
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }

        // Left shift the result by the number of shifts obtained to restore the common prefix
        return left << shiftCount;
    }
}
