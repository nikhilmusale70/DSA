package Heaps2;

public class WaysToFormMaxHeap {
    public static void main(String[] args) {
        int A = 10;
        System.out.println(new WaysToFormMaxHeap().solve(A));
    }

    public int solve(int A) {
        int twoHminusOne = (int)(Math.pow(2, (Math.log(A)-1)))  ;
        int l = twoHminusOne - 1 + Math.min( A - (twoHminusOne*2 - 1) , twoHminusOne);
        int totalNum = nCr(A-1, l) * l * (A-1-l);
        return totalNum;
    }

    static int nCr(int n, int r)
    {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n)
    {
        if(n==0)
            return 1;
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}
