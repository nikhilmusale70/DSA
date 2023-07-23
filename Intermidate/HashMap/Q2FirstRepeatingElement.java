package HashMap;

import Utils.ScaUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class Q2FirstRepeatingElement {
    /*Problem Description
Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
The first and only argument is an integer array A of size N.



Output Format
Return an integer denoting the first repeating element.



Example Input
Input 1:

 A = [10, 5, 3, 4, 3, 5, 6]
Input 2:

 A = [6, 10, 5, 4, 9, 120]


Example Output
Output 1:

 5
Output 2:

 -1


Example Explanation
Explanation 1:

 5 is the first element that repeats
Explanation 2:

 There is no repeating element, output -1
*/

    public static void main(String[] args) {
        int[] arr = {7, 6, 6, 3, 1, 5, 7 };
        ArrayList<Integer> arrLis = ScaUtils.arrToArrayList(arr);

        System.out.println(solve(arrLis));
    }

    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<A.size(); i++){
            if(hm.containsKey(A.get(i))){
                hm.put(A.get(i), hm.get(A.get(i))+1 );
            }
            else{
                hm.put(A.get(i), 1);
            }
        }

        //iterate over array and see for the elem
        for(int i=0; i<A.size(); i++){
            if(hm.get(A.get(i))>1){
                return A.get(i);
            }
        }

        return -1;
    }
}
