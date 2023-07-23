package Maths4Combimatrics;

public class PrimeModuloInverse {
    public static void main(String[] args) {
        System.out.println("Kil:" +solve(9,13));
    }

    public static int solve(int A, int B) {
        return pow(A, B-2, B);
    }

    public static int pow(int number, int power, int mod){
        if (number==0) return 0;
        if (power==0) return 1;
        long halfPow = pow(number, power/2, mod)%mod;
        long powTemp = ((halfPow)*(halfPow))%mod;

        if((power&1)==0) return (int) ((powTemp + mod)%mod);
        else return (int) ((powTemp*number + mod)%mod);
    }
}
