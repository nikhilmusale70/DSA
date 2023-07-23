package Stacks2.Homework;

import java.util.Arrays;
import java.util.Stack;

public class MaxRectangleWith1s {
    public static void main(String[] args) {
        int[][] A = {
                        {0, 0, 1},
                        {0, 1, 1},
                        {1, 1, 1},
                    };
        MaxRectangleWith1s obj = new MaxRectangleWith1s();
        System.out.println(obj.solve(A));
    }

    public int solve(int[][] A) {
        int[][] arrHistoGram = new int[A.length][A[0].length];

        for (int i=0; i<A.length; i++){
            Arrays.fill(arrHistoGram[i], 0);
        }

        //lets create histo grams
        for (int i=0; i<A.length; i++){
            if(i==0) {
                arrHistoGram[i] = A[i];
                continue;
            }
            for (int j=0; j<A[i].length; j++){
                if(A[i][j]==1){
                    arrHistoGram[i][j] = arrHistoGram[i-1][j]+1;
                }
                else{
                    arrHistoGram[i][j] = 0;
                }
            }
        }

        int ans=0;
        //histo gram is created now, lets call our function
        for (int i=0; i<arrHistoGram.length; i++){
            int areaOfRect = largestRectangleArea(arrHistoGram[i]);
            ans = Math.max(ans, areaOfRect);
        }

        return ans;
    }

    public int largestRectangleArea(int[] A) {
        int[] leftSmallNearElem = leftSmallestIndex(A);
        int[] rightSmallNearElem = greatNearRightIndex(A);
        int ans=Integer.MIN_VALUE;

        int height = 0;
        int breath = 0;
        //arr = height * breath;
        //iterate over the array and find area for rect
        for (int i=0; i<A.length; i++){
            height = A[i];

            int rightBlocks = rightSmallNearElem[i]==-1? A.length-i-1 : rightSmallNearElem[i]-i-1;
            int leftBlocks = leftSmallNearElem[i]==-1? i : i-leftSmallNearElem[i]-1;
            breath = rightBlocks+leftBlocks+1;
            int area = Math.abs(height * breath);
            ans = Math.max(area, ans);
        }

        return ans;
    }

    public int[] leftSmallestIndex(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i])
                stk.pop();
            if(stk.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stk.peek();
            stk.push(i);
        }
        return ans;
    }

    public int[] greatNearRightIndex(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i=arr.length-1; i>=0; i--){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i])
                stk.pop();
            if(stk.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stk.peek();
            stk.push(i);
        }
        return ans;
    }
}
