package Stacks2;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        int[] A = {6, 2, 5, 4, 5, 1, 6};

        System.out.println(obj.largestRectangleArea(A));
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
