/*
Problem Description
You are given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints
1 <= N <= 100000

0 <= B < N



Input Format
The first argument is a string A.

The second argument is an integer B.



Output Format
Return an integer denoting the minimum number of distinct characters in the string.



Example Input
A = "abcabbccd"
B = 3



Example Output
2



Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
 */
package String.HomeWork;

import Utils.ScaUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class ChangeChar {
    public static void main(String[] args) {
        int e=10;
        float real = e;
        System.out.println(solve("abcabbccd", 3));
    }

    public static int solve(String A, int B) {
        int[] freq = new int[26];
        int ans=0, i;

        for (char ch:A.toCharArray()){
            i = ch - 'a';
            freq[i]++;
            if(freq[i]==1){
                ans++;
            }
        }
        if(B<=0 || B==ans){
            return ans;
        }

        Arrays.sort(freq);
        for (int num: freq){
            if(B-num>=0 && num!=0){
                ans--;
                B-=num;
            }
        }
        return ans;
    }
}
