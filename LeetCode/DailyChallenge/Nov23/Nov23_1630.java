package DailyChallenge.Nov23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nov23_1630 {
    public static void main(String[] args) {
        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};

        Nov23_1630 obj = new Nov23_1630();
        System.out.println(obj.checkArithmeticSubarrays(nums, l, r));
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i=0; i<l.length; i++){
            int[] subArr = Arrays.copyOfRange(nums, l[i], r[i]+1);
            ans.add(checkIfSubStringPossible(subArr));
        }
        return ans;
    }

    boolean checkIfSubStringPossible(int[] arr){
        Arrays.sort(arr);
        int commonDiff = arr[1] - arr[0];
        for(int i=2; i<arr.length; i++){
            if(arr[i]-arr[i-1] != commonDiff){
                return false;
            }
        }
        return true;
    }
}
