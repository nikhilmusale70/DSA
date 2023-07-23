package AdvanceDsa_Interview_Problems;

public class FirstMissingInteger {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 2 };
        System.out.println(firstMissingPositive(A));
    }

    public static int firstMissingPositive(int[] A) {
        for(int i=0; i<A.length; i++){
            if(A[i]<0){
                A[i] = A.length+2;
            }
        }
        for(int i=0; i<A.length; i++){
            int elem = A[i]>0?A[i] : -1*A[i];
            if(elem>=1 && elem<=A.length){
                int index = elem - 1;
                A[index] = -1 * A[index]>0?A[index] : -1*A[index];

            }
        }

        for (int i=0; i<A.length; i++){
            if(A[i]>0){
                return i+1;
            }
        }

        return A.length+1;
    }
}
