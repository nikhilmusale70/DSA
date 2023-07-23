package Recursion;

public class PrintFromATo1 {
    public static void main(String[] args) {
        solve(10);
    }

    public static void solve(int n){
        print(n);
    }

    public static void print(int n){
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        else {
            System.out.print(n + " ");
            print(n-1);
            return;
        }
    }
}
