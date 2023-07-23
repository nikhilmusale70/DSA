package Hashing2GeometryAndString;

/*
* Problem Description
Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )


Problem Constraints
1 <= size(A), size(B) <= 106



Input Format
The first argument is a string A.
The second argument is a string B.



Output Format
Return a string denoting the minimum window.



Example Input
Input 1:

 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:

 A = "Aa91b"
 B = "ab"


Example Output
Output 1:

 "BANC"
Output 2:

 "a91b"


Example Explanation
Explanation 1:

 "BANC" is a substring of A which contains all characters of B.
Explanation 2:

 "a91b" is the substring of A which contains all characters of B.*/
public class WindowString {
    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";
        WindowString obj = new WindowString();
        System.out.println(obj.minWindow(A.toLowerCase(),B.toLowerCase()));

    }


    public String minWindow(String A, String B) {
        //a->0 || z->25
        int[] charB = new int[26];
        int i=0;
        while (i<B.length()){
            charB[A.charAt(i)-'a']++;
            i++;
        }

        //lets use 2 pointer and see if get all the char from b in a
        int[] checkArr = new int[26];

        //let's initially create a array with B size for then use 2 pointer approch
        for (i=0; i<B.length(); i++){
            checkArr[A.charAt(i)-'a']++;
        }

        int start=0; int end=i; int sizeOfSubArray=Integer.MAX_VALUE;
        int leftPointer=0; int rightPointer=end;
        while (rightPointer<A.length()){
            checkArr[A.charAt(rightPointer)-'a']++;
            checkArr[A.charAt(leftPointer)-'a']--;

            while (count(checkArr, charB)){
                if (sizeOfSubArray>(rightPointer-leftPointer) ){
                    sizeOfSubArray = rightPointer-leftPointer;
                    start = leftPointer;
                    end = rightPointer;
                }
                leftPointer++;
            }
            rightPointer++;
        }

        System.out.println("Start: "+start + " end: "+end);
        return A.substring(start, end);
    }

    //check if a has all the char of b;
    boolean count(int[] A, int[] B){
        for (int i=0; i<B.length; i++){
            if(B[i]>A[i]){
                return false;
            }
        }
        return true;
    }
}
