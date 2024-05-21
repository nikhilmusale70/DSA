package DailyChallenge.May24;

import java.util.ArrayList;
import java.util.List;

public class May21_78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        May21_78 obj = new May21_78();
        System.out.println(obj.subsets(nums));
    }
    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        generateSubsets(nums, 0, new ArrayList<>());
        return ans;
    }

    void generateSubsets(int[] nums, int index, ArrayList<Integer> ansList){
        if(index == nums.length){
            return;
        }

        //do call the function
        ansList.add(nums[index]);
        ans.add(new ArrayList<>(ansList));

        generateSubsets(nums, index+1, ansList);

        //undo call the function
        ansList.remove(Integer.valueOf(nums[index]));
        generateSubsets(nums, index+1, ansList);
    }
}
