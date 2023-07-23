package StringPatternMatching;

/*
* Problem Description
You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is a string A.



Output Format
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.



Example Input
Input 1:

 A = "abcd"
Input 2:

 A = "aab"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 String A can be rearranged into "cadb" or "bdac"
Explanation 2:

 No arrangement of string A can make it free of boring substrings.*/
public class BoringSubstring {
    public static void main(String[] args) {
        BoringSubstring obj = new BoringSubstring();
        String A = "abcd";
        System.out.println(obj.solve(A));
    }
    public int solve(String A) {
        int lowEven=Integer.MAX_VALUE, maxEven=Integer.MIN_VALUE;
        int lowOdd=Integer.MAX_VALUE, maxOdd=Integer.MIN_VALUE;
        for (int i=0; i<A.length(); i++){
            int charVal = A.charAt(i)-'a'+1;
            if(charVal%2 == 0){
                //even
                lowEven = Math.min(lowEven, charVal);
                maxEven = Math.max(maxEven, charVal);
            }
            else {
                //odd
                lowOdd = Math.min(lowOdd, charVal);
                maxOdd = Math.max(maxOdd, charVal);
            }
        }

        //see if they are consecutive
        if(Math.abs(maxEven-lowOdd)!=1 || Math.abs(lowEven-maxOdd)!=1)
            return 1;
        return 0;
    }

}
