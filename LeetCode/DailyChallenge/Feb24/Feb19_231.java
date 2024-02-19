package DailyChallenge.Feb24;

public class Feb19_231 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        int n = -2147483648;
        Feb19_231 obj = new Feb19_231();
        System.out.println(obj.isPowerOfTwo(n));
    }
    public boolean isPowerOfTwo(int n) {
        // Check if n is the minimum value for Integer, which cannot be represented as a power of 2
        if (n == Integer.MIN_VALUE)
            return false;

        // Count the number of set bits in n
        int countSetBit = 0;
        for (int i = 0; i < 32; i++) { // Since integer is 32 bits
            if (checkBit(i, n)) { // Check if the ith bit is set
                countSetBit++; // Increment the count of set bits
            }
        }

        // If there is only one set bit, then n is a power of 2
        if (countSetBit == 1) {
            return true;
        }
        return false;
    }

    // Helper function to check if the idx-th bit of num is set
    boolean checkBit(int idx, int num) {
        // Shift 1 to the left by idx positions and perform bitwise AND with num
        // If the result is non-zero, then the idx-th bit of num is set
        if (((1 << idx) & num) != 0) {
            return true; // Bit is set
        }
        return false; // Bit is not set
    }

}
