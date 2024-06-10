package DailyChallenge.June24;

import java.util.Arrays;

public class June8_1051 {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        June8_1051 obj = new June8_1051();
        System.out.println(obj.heightChecker(heights));
    }
    public int heightChecker(int[] heights) {
        int ans = 0;
        int[] arr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=heights[i]) ans++;
        }
        return ans;
    }
}
