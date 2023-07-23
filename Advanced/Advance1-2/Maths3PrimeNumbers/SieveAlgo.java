package Maths3PrimeNumbers;

import java.util.Arrays;

public class SieveAlgo {
    public static void main(String[] args) {
        int A = 15;
        sieveAlgo(A);
    }

    public static void sieveAlgo(int A){
        boolean[] sieveArr = new boolean[A+1];
        Arrays.fill(sieveArr, 2, A+1, true);

        for (int i=2; i*i<=A; i++){
            if(sieveArr[i]){
                for (int j=i*i; j<=A; j+=i){
                    sieveArr[j]=false;
                }
            }
        }
    }
}
