package DailyChallenge.Nov;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class nov12_2070 {
    public static void main(String[] args) {
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = {1,2,3,4,5,6};
        nov12_2070 obj= new nov12_2070();
        System.out.println(Arrays.toString(obj.maximumBeauty(items, queries)));
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b)->{
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] ans = new int[queries.length];
        int max = items[0][1];
        for(int i=0; i<items.length; i++){
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }
        for(int i=0; i<ans.length; i++){
            ans[i] = findLowestPriceWithMaxBeauty(queries[i], items);
        }
        return ans;
    }

    int findLowestPriceWithMaxBeauty(int price, int[][] items){
        int l = 0;
        int r = items.length-1;
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(items[mid][0]<=price){
                ans = Math.max(ans, items[l][1]);
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }
}
