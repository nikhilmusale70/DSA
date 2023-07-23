package Math2GCD.HomeWork;

public class DivisorGame {
    public static void main(String[] args) {
        DivisorGame obj = new DivisorGame();
        System.out.println(obj.solve(6,2,4));
    }
    public int solve(int A, int B, int C) {
        return A/LCM(B,C);
    }
    int LCM(int B, int C){
        return  (B*C)/GCD(B,C);
    }
    int GCD(int A, int B){
        if(A<B){
            int temp = A;
            A=B;
            B=temp;
        }
        if(B==0)return A;
        return GCD(A%B, B);
    }
}
