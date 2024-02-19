package DailyChallenge.Feb24;

public class Feb19_231 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        int n = -2147483648;
        Feb19_231 obj = new Feb19_231();
        System.out.println(obj.isPowerOfTwo(n));
    }
    public boolean isPowerOfTwo(int n) {
        // Check if n is less than or equal to 0, in which case it cannot be a power of two
        if (n <= 0)
            return false;

        // If n is 1, it is a power of 2
        if (n == 1)
            return true;

        // If n is odd, it cannot be a power of 2
        if (n % 2 == 1)
            return false;

        // Recursively check if n/2 is a power of 2
        return isPowerOfTwo(n / 2);
    }

}
