/*
Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Input Format
First argument is an integer array A
Second argument is an integer B.



Output Format
Return an integer array.



Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation
Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].


 */

package Hashing2;

import Utils.ScaUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 3};
        ArrayList<Integer> arrLis = ScaUtils.arrToArrayList(arr);
        int windowSize=3;
        System.out.println(dNums(arrLis, windowSize));

    }

    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> disctinctElems = new ArrayList<>();
        if(B>A.size()){
            return disctinctElems;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        int removeIndex;
        //1st window
        for (int i=0; i<B; i++){
            if(hm.containsKey(A.get(i))){
                hm.put(A.get(i), hm.get(A.get(i)) + 1);
            }
            else{
                hm.put(A.get(i), 1);
            }
        }
        disctinctElems.add(hm.size());

        System.out.println(A);
        for(int i=B; i<A.size(); i++){
            //removing
            removeIndex = i-B;
            if(hm.get(A.get(removeIndex))>1){
                hm.replace(A.get(removeIndex), hm.get(A.get(removeIndex))-1);
            }
            else{
                hm.remove(A.get(removeIndex));
            }
//            System.out.println("Removing: "+A.get(removeIndex));
//            System.out.println("HashMaps: "+hm);

            //adding
            if(hm.containsKey(A.get(i))){
                hm.put(A.get(i), hm.get(A.get(i)) + 1);
            }
            else{
                hm.put(A.get(i), 1);
            }
            System.out.println("Adding: "+A.get(i));
            System.out.println("HashMaps: "+hm);

            disctinctElems.add(hm.size());
        }

        return disctinctElems;
    }
}
