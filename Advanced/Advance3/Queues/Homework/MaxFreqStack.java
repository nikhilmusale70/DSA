package Queues.Homework;

import java.util.*;

public class MaxFreqStack {
    public static void main(String[] args) {
        MaxFreqStack obj = new MaxFreqStack();
        int[][] A =  {
                {1, 5},
                {1, 7},
                {1, 5},
                {1, 7},
                {1, 4},
                {1, 5},
                {2, 0},
                {2, 0},
                {2, 0},
                {2, 0}   }; // 5 7 5 7 4 5
        System.out.println(Arrays.toString(obj.solve(A)));
    }

    HashMap<Integer, Integer> hm;
    HashMap<Integer, Stack<Integer>> hashStks;
    int maxFreq;
    public int[] solve(int[][] A) {
        hm = new HashMap<>();
        hashStks = new HashMap<>();
        maxFreq = 0;

        int[] ans = new int[A.length];

        for (int i=0; i<A.length; i++){
            int[] curr = A[i];

            if(curr[0]==1){
                ans[i] = push(curr[1]);
            }
            else
                ans[i] = pop();
        }
        return ans;
    }

    public int push(int val){
        int currFreq = hm.getOrDefault(val, 0)+1;
        hm.put(val, currFreq);

        if(hashStks.containsKey(currFreq)==false){
            hashStks.put(currFreq, new Stack<>());
        }

        hashStks.get(currFreq).push(val);
        maxFreq = Math.max(maxFreq, currFreq);

        return -1;
    }

    int pop(){
        int val = hashStks.get(maxFreq).pop();
        int currFreq = hm.get(val);
        currFreq--;

        hm.put(val, currFreq);


        if(hashStks.get(maxFreq).isEmpty()){
            maxFreq--;
        }

        return val;
    }

}
