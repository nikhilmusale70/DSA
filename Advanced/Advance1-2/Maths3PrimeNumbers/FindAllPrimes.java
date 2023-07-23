package Maths3PrimeNumbers;

import adv12Utils.ScaUtils;
import java.util.Arrays;

/*
Problem Description
Given an integer A. Find the list of all prime numbers in the range [1, A].


Problem Constraints
1 <= A <= 106



Input Format
Only argument A is an integer.



Output Format
Return a sorted array of prime number in the range [1, A].



Example Input
Input 1:
A = 7
Input 2:
A = 12


Example Output
Output 1:
[2, 3, 5, 7]
Output 2:
[2, 3, 5, 7, 11]


Example Explanation
For Input 1:
The prime numbers from 1 to 7 are 2, 3, 5 and 7.
For Input 2:
The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.
 */
public class FindAllPrimes {
    public static void main(String[] args) {
        int A = 12;
        ScaUtils.printNormalArray(solve(A));
    }

    public static int[] solve(int A) {
        boolean[] sieveArr = new boolean[A+1];
        Arrays.fill(sieveArr, 2, A+1, true);
        int countOfTrue = 0;

        for (int i=2; i*i<=A; i++){
            if(sieveArr[i]){
                for (int j=i*i; j<=A; j+=i){
                    sieveArr[j] = false;
                }
            }
        }
        for(boolean temp: sieveArr){
            if(temp){
                countOfTrue++;
            }
        }

        int[] ans = new int[countOfTrue];
        for (int i=2,j=0; i<=A; i++){
            if (sieveArr[i]){
                ans[j] = i;
                j++;
            }
        }

        return ans;
    }
}
