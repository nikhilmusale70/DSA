package DailyChallenge.Aug24;

import java.util.ArrayList;
import java.util.List;

public class Aug23_592 {
    public static void main(String[] args) {
        Aug23_592 obj = new Aug23_592();
        System.out.println(obj.fractionAddition("-1/2+1/2+1/3"));  // Example expression
    }

    public String fractionAddition(String expression) {
        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();

        int i = 0;
        while (i < expression.length()) {
            int sign = 1;

            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }

            int numerator = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                numerator = numerator * 10 + (expression.charAt(i) - '0');
                i++;
            }
            numerator *= sign;
            numerators.add(numerator);

            i++; // Skip the '/'
            int denominator = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                denominator = denominator * 10 + (expression.charAt(i) - '0');
                i++;
            }
            denominators.add(denominator);
        }

        // Find LCM of all the denominators
        int LCM = findLCMofList(denominators);

        // Calculate the numerator with the common denominator
        int finalNumerator = 0;
        for (int j = 0; j < numerators.size(); j++) {
            finalNumerator += numerators.get(j) * (LCM / denominators.get(j));
        }

        // Simplify the resulting fraction
        int gcd = findGCD(Math.abs(finalNumerator), LCM);
        finalNumerator /= gcd;
        LCM /= gcd;

        return finalNumerator + "/" + LCM;
    }

    // Method to find the GCD of two numbers
    int findGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    // Method to find the LCM of two numbers
    int findLCM(int a, int b) {
        return Math.abs(a * b) / findGCD(a, b);
    }

    // Method to find the LCM of a list of numbers
    int findLCMofList(List<Integer> numbers) {
        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = findLCM(result, numbers.get(i));
        }
        return result;
    }
}
