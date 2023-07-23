package Maths1ModularArithmatic;

public class ImplementPowerFunction {
    public static void main(String[] args) {
        System.out.println(newPow(2,3,100));
    }

    public static int newPow(int A, int B, int C){
        //base case
        if(A == 0){
            return 0;
        }
        if(B == 0){
            return 1;
        }

        long temp;
        //if B is even
        if(B % 2 == 0){
            temp = newPow(A, B/2, C);
            temp = (temp * temp) % C;
        }

        //if B is odd
        else{
            temp = A % C;
            temp = (temp * newPow(A, B - 1, C) % C) % C;
        }
        return (int)((temp + C) % C);
    }
}
