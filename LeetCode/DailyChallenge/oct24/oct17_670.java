package DailyChallenge.oct24;

import java.util.PriorityQueue;

public class oct17_670 {
    public static void main(String[] args) {
        int num = 98368;
        oct17_670 obj = new oct17_670();
        System.out.println(obj.maximumSwap(num));
    }
    public int maximumSwap(int num) {
        StringBuilder str = new StringBuilder(Integer.toString(num));
        int n = str.length();
        int[] maxIdx = new int[n];

        maxIdx[n-1] = n-1;
        for(int i=n-2; i>=0; i--){
            maxIdx[i] = str.charAt(i)>str.charAt(maxIdx[i+1])?i:maxIdx[i+1];
        }

        for(int i=0; i<n-1; i++){
            if(str.charAt(i)<str.charAt(maxIdx[i])){
                //replace
                int temp = str.charAt(i)-'0';
                str.replace(i,i+1,String.valueOf(str.charAt(maxIdx[i])));
                str.replace(maxIdx[i], maxIdx[i]+1, String.valueOf(temp));
                break;
            }
        }
        return Integer.parseInt(str.toString());
    }
}
