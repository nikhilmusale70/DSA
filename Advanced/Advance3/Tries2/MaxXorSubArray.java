package Tries2;

import java.util.Arrays;
import java.util.HashMap;

public class MaxXorSubArray {
    public static void main(String[] args) {
        MaxXorSubArray obj = new MaxXorSubArray();
        int[] A = {1, 4, 3};
        System.out.println(Arrays.toString(obj.solve(A)));
    }

    public int[] solve(int[] A) {
        //lets creat pf array
        int[] pfArr = new int[A.length];
        pfArr[0] = A[0];
        for(int i=1; i<A.length; i++){
            pfArr[i] = pfArr[i-1]^A[i];
        }

        //lets store pf array in trie
        return helper(pfArr);
    }

    public int[] helper(int[] A) {
        //create a trie tree
        for(int i=0; i<A.length; i++){
            String str = String.format("%30s", Integer.toBinaryString(A[i])).replaceAll(" ", "0");
            constructTrie(str);
        }

        //now lets find out the max xor
        int maxXor = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int firstIndex = 0, secondIndex = 0;

        for (int i=0; i<A.length; i++){
            hm.put(A[i], i);
            String str = String.format("%30s", Integer.toBinaryString(A[i])).replaceAll(" ", "0");
//            maxXor = Math.max(maxXor, searchInTrie(str));
            int firstElement = A[i];
            int anotherElementForXorToBeMax = searchInTrie(str);
            int checkIfMax = A[i] ^ anotherElementForXorToBeMax;
            if(maxXor<checkIfMax){
                maxXor = checkIfMax;
                firstIndex = i;
                secondIndex = anotherElementForXorToBeMax;
            }
        }

        return new int[]{firstIndex, secondIndex};
    }

    MaxXor.TrieNode root = new MaxXor.TrieNode();
    static class TrieNode{
        MaxXor.TrieNode[] child;
        TrieNode() {
            child = new MaxXor.TrieNode[2];
        }
    }

    int searchInTrie(String number){
        StringBuilder ans = new StringBuilder();
        MaxXor.TrieNode temp = root;

        for(int i=0; i<number.length(); i++){
            int curr = Integer.parseInt(number.charAt(i)+"");
            if(curr==1){
                if(temp.child[0]!=null){
                    ans.append(0);
                    temp = temp.child[0];
                }
                else{
                    ans.append(1);
                    temp = temp.child[1];
                }
            }
            //curr==0
            else{
                if(temp.child[1]!=null){
                    ans.append(1);
                    temp = temp.child[1];
                }
                else{
                    ans.append(0);
                    temp=temp.child[0];
                }
            }
        }
        //convert ans into int
        return Integer.parseInt(ans+"", 2);
    }

    void constructTrie(String number){
        MaxXor.TrieNode temp = root;
        for(int i=0; i<number.length(); i++) {
            int curr = Integer.parseInt(number.charAt(i) + "");
            if (temp.child[curr] == null) {
                temp.child[curr] = new MaxXor.TrieNode();
            }
            temp = temp.child[curr];
        }
    }
}
