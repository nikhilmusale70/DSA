package AdvanceHashing1;

import adv12Utils.ScaUtils;

import java.util.ArrayList;

/*
* Problem Description
Given a binary string A of size N. There are Q queries given by the array B of size Q*2.

Each query is given by :-

1 X :- Flip the bit of the X-th position in A

2 X :- Find the index of the nearest '1' from X. If there are multiple such indexes, return the one with the lower index. Return -1 if there are no '1's in A

Note :- We use 1-based indexing



Problem Constraints
1 <= N <= 105

1 <= Q <= 105

1 <= B[i][0] <= 2

1 <= B[i][1] <= N



Input Format
First argument A is a string.

Second argument B is a 2D array of integers describing the queries.



Output Format
Return an array of integers denoting the answers to each query of type 2.



Example Input
Input 1:
A = "10010"
B = [[1, 2]
     [2, 3]]
Input 2:
A = "010000100"
B = [[2, 5]
     [1, 7]
     [2, 9]]


Example Output
Output 1:
[2]
Output 2:
[7, 2]


Example Explanation
For Input 1:
After first query, A = "11010".
For second query, X = 3. Both index 2 and index 4 are at the same
distance but we choose the lower index.
For Input 2:
For first query, the index 2 is at a distance 3 and index 7 is at a distance 2. So we choose
index 7.
After second query, A = "010000000"
For third query, the only index with '1' is 2.*/
public class FlipAndNearest {
    public static void main(String[] args) {
        String A = "01001";
        int[][] B = {{2, 4}}

//                {
//                {2, 3},
//                {2, 1},
//                {1, 4},
//                {2, 4},
//                {2, 5},
//                {1, 2},
//                {1, 4},
//                {2, 1},
//                {2, 3}
//        }
                ;

        FlipAndNearest obj = new FlipAndNearest();
        ScaUtils.printNormalArray(obj.solve(A, B));
    }

    public int[] solve(String A, int[][] B) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<B.length; i++){
            //iterating on queries

            //type 1
            if(B[i][0]==1){
                A = typeOne(A, B[i][1]);
            }
            //type 2
            else{
                arr.add(typeTwo(A, B[i][1]));
            }
            System.out.println("After i: " + i + " A; " + A);
        }
        int[] ans = new int[arr.size()];
        for (int i=0; i<arr.size(); i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
    int typeTwo(String A, int index){
        index--;

        System.out.println(A + " For index: "+index);
        int l=index, r=index;
        while(l>=0 || r<A.length()){
            if(l>=0 && A.charAt(l)=='1'){
                return l+1;
            }
            if (r<A.length() && A.charAt(r)=='1'){
                return r+1;
            }
            if(l>=0)
                l--;
            if(r<A.length())
                r++;
        }
        return -1;
    }

    String typeOne(String A, int bitNumberToFlip){
        bitNumberToFlip--;
        A = A.charAt(bitNumberToFlip)=='1'
                ? (A.substring(0,bitNumberToFlip)+'0'+A.substring(bitNumberToFlip+1))
                : (A.substring(0,bitNumberToFlip)+'1'+A.substring(bitNumberToFlip+1));
        return A;
    }
}
