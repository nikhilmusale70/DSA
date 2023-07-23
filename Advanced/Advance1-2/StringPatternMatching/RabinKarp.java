package StringPatternMatching;

/*
* Problem Description
Given two string A and B of length N and M respectively consisting of lowercase letters. Find the number of occurrences of B in A.


Problem Constraints
1 <= M <= N <= 105



Input Format
Two argument A and B are strings


Output Format
Return an integer denoting the number of occurrences of B in A


Example Input
Input 1:
A = "acbac"
B = "ac"
Input 2:
A = "aaaa"
B = "aa"


Example Output
Output 1:
2
Output 2:
3


Example Explanation
For Input 1:
The string "ac" occurs twice in "acbac".
For Input 2:
The string "aa" occurs thrice in "aaaa".
*/
public class RabinKarp {
    public static void main(String[] args) {
        String A = "acbac";
        String B = "ac";
        RabinKarp obj = new RabinKarp();
        System.out.println(obj.solve(A,B));
    }
    public int solve(String A, String B) {
        int ans=0;
        long p = 27;
        long mod = 1000000007;

        long hashOfB = 0;
        long sum = 0;

        //lets create our own pow arr of size k
        //because math.pow overflows
        long[] powArr = new long[B.length()];
        powArr[0] = 1;
        for (int i=1; i<B.length(); i++){
            powArr[i] = (p*powArr[i-1])%mod;
        }

        //get the hash value of B
        //create a window from a
        int k = B.length()-1;
        for (int i=0; i<B.length(); i++){
            hashOfB = ( hashOfB + ((B.charAt(i)-'a'+1)*powArr[k-i])%mod )%mod;
            sum = ( sum + ((A.charAt(i)-'a'+1)*powArr[k-i])%mod)%mod;
        }


        if (sum==hashOfB){
            ans++;
        }
        //sliding window
        //creating 2 pointer i and j
        int i=0,j=B.length();
        System.out.println(sum);

        while(j<A.length()) {
            //from sum delete the first element -> i
            sum = sum - ( (A.charAt(i)-'a'+1)*powArr[B.length()-1] )%mod;
            System.out.println("Remove element: "+sum);
            //multiple with p
            sum = (sum * p)%mod;
            System.out.println("Multi: "+sum);

            //add the new element in window
            sum = (sum + (A.charAt(j)-'a'+1) )%mod;
            System.out.println("After New element: "+sum);

            //check if the value is equal to hashValue of B
            if (sum == hashOfB) {
                ans++;
            }

            i++; j++;
        }
        return ans;
    }
}
