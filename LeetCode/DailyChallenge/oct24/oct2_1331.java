package DailyChallenge.oct24;

import java.util.Arrays;
import java.util.HashMap;

public class oct2_1331 {
    public static void main(String[] args) {
        int[] arr = {40,40};
        oct2_1331 obj = new oct2_1331();
        System.out.println(Arrays.toString(obj.arrayRankTransform(arr)));
    }
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;
        for(int i=0; i<arr.length; i++){
            if(i>0 && sortedArr[i]>sortedArr[i-1]) rank++;
            ranks.put(sortedArr[i], rank);
        }

        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            ans[i] = ranks.get(arr[i]);
        }
        return ans;
    }
}
