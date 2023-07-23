package SortingRadixAndCountSort.Homework;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] A = {8,89};
        LargestNumber obj = new LargestNumber();
        System.out.println(obj.largestNumber((A)));
    }
    public String largestNumber(final int[] A) {
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        Arrays.sort(B, comparator);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B.length; i++) {
            sb.append(B[i]);
        }

        // Remove leading zeros
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }

        return sb.substring(i);
    }

    Comparator<Integer> comparator = new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            String ab = String.valueOf(a) + String.valueOf(b);
            String ba = String.valueOf(b) + String.valueOf(a);
            return ba.compareTo(ab);
        }
    };
}
