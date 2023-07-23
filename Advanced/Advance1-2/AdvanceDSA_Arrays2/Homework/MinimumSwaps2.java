package AdvanceDSA_Arrays2.Homework;

public class MinimumSwaps2 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 0};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int n = A.length, s=0, count=0, temp;
        while(s<n){
            if(A[s]!=s){
                count++;
                temp = A[A[s]];
                A[A[s]] = A[s];
                A[s] = temp;
            }
            else s++;
        }
        return count;
    }
}
