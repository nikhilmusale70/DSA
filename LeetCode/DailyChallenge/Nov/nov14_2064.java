package DailyChallenge.Nov;

import java.util.Arrays;

public class nov14_2064 {
    public static void main(String[] args) {
        int n = 2;
        int[] quantities = {5,7};
        nov14_2064 obj = new nov14_2064();
        System.out.println(obj.minimizedMaximum(n, quantities));
    }

    public int minimizedMaximum(int n, int[] quantities) {
        //1. get the max quantity
        int max = 0;
        for(int quantity: quantities){
            max = Math.max(max, quantity);
        }
        //2. check the least of quantity we can allocate
        int left = 0;
        int right = max;
        while (left<right){
            int mid = left + (right - left)/2;
            if(canWeAllocate(mid, n, quantities)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    boolean canWeAllocate(int max, int shopsWeHave, int[] quantities){
        //to allocate max we require, quanntities[i]/max shops
        int shopsNeeded = 0;
        for(int quantity: quantities){
            shopsNeeded += (int)Math.ceil((quantity*1.0)/max);
            if(shopsNeeded>shopsWeHave) return false;
        }
        return true;
    }
}
