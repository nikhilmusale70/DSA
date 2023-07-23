package BitManipulationProblems.Homework;
/*
Problem Description
Given an integer A.
Two numbers, X and Y, are defined as follows:

X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum of 100000 Test Cases.



Problem Constraints
1 <= A <= 109



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the XOR of X and Y.



Example Input
A = 5


Example Output
10


Example Explanation
The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.
 */
public class StrangeEquality {
    public static void main(String[] args) {
        int A = 5;
        System.out.println(solve(A));

    }
    public static int solve(int A) {
        int x=0, flagX=1;
        //lets find X
        //x should be less that than a
        for (int index=31; index>=0; index--){
            if (checkBit(A, index)){
                flagX=0;
            }
            if(!checkBit(A,index) && flagX==0){
                x += 1<<index;
            }
        }

        int y=0, flagY=1, leftMostSetBit=0;
        //lets find Y
        //y should be just greater than a
        //find left most set bit
        for (int index=31; index>=0; index--){
            if (checkBit(A, index)){
                leftMostSetBit = index;
                break;
            }
        }

        y = 1<<(leftMostSetBit+1);

        return x^y;
    }

    public static boolean checkBit(int number, int index){
        if( ((1<<index)&number) != 0) return true;
        else return false;
    }
}
