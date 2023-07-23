package Math2GCD.HomeWork;

public class EnumeratingGCD {
    public static void main(String[] args) {
        EnumeratingGCD obj = new EnumeratingGCD();
        System.out.println(obj.solve("10", "20"));
    }

    public String solve(String A, String B) {
        return A.equals(B)?A:1+"";
    }
}
