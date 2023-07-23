package BitManipulationProblems;

/*Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.


Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
The first argument is an array of integers of size N.



Output Format
Return an array of two integers that appear only once.



Example Input
Input 1:
A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:
[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:
3 and 4 appear only once.
Explanation 2:

1 and 2 appear only once.

*/
public class SingleNumberIII {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 2, 4};
        System.out.println(solve(A));
    }
    public static int[] solve(int[] A) {
        int result = 0;
        //take xor of every element
        for (int i=0; i<A.length; i++){
            result ^= A[i];
        }

        //now result will have xor of 2 unique number,
        //check the set bits, and make 2 buckets for 0 and 1;

        //check the set bit, and store it in index
        int index=-1;
        for (int i=0; i<31; i++){
            if (checkBit(result, i)){
                index = i;
                break;
            }
        }

        //dividing in bucket using the index
        int fromBucket1=0, fromBucket2=0;
        for (int i=0; i<A.length; i++){
            if(checkBit(A[i], index)){
                fromBucket1 ^= A[i];
            }
            else {
                fromBucket2 ^= A[i];
            }
        }

        int[] ans = new int[2];

        if(fromBucket2>fromBucket1){
            ans[0]=fromBucket1;
            ans[1]=fromBucket2;
        }
        else{
            ans[0]=fromBucket2;
            ans[1]=fromBucket1;
        }
        return ans;
    }

    public static boolean checkBit(int number, int index){
        if( ((1<<index)&number)!= 0) return true;
        else return false;
    }
}
