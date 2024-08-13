package DailyChallenge.Aug24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aug13_40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Aug13_40 obj = new Aug13_40();
        System.out.println(obj.combinationSum2(candidates, target));
    }

    List<Integer> temp;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(target, 0, candidates, ans);
        return ans;
    }

    void helper(int target, int idx, int[] candidates, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            if(i>idx && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            temp.add(candidates[i]);
            helper(target-candidates[i], i+1, candidates, ans);
            temp.removeLast();
        }
    }
}
