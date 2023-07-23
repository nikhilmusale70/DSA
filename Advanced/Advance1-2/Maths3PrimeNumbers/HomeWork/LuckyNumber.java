package Maths3PrimeNumbers.HomeWork;

public class LuckyNumber {
    public static void main(String[] args) {
        int A = 8;
        System.out.println(solve(A));
    }
    static int[] sieveArr;
    public static void calFactorsSieve(int A){
        sieveArr = new int[A+1];

        for (int i=2; i<=A; i++){
            if (sieveArr[i]==0){
                for (int j=i; j<=A; j+=i){
                    sieveArr[j]+=1;
                }
            }
        }
    }

    public static int solve(int A) {
        calFactorsSieve(A);

        int count=0;
        for (int i=0; i<=A; i++){
            if (sieveArr[i]==2){
                count++;
            }
        }

        return count;
    }


}
