package DailyChallenge.Nov23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Nov22_1424 {
    public static void main(String[] args) {
        Nov22_1424 obj = new Nov22_1424();
        List<List<Integer>> nums = List.of(List.of(14,12,19,16,9),List.of(13,14,15,8,11),List.of(11,13,1));
        System.out.println(Arrays.toString(obj.findDiagonalOrder(nums)));
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        fillMap(nums, hm);
        //lets just iterate on map
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<hm.size(); i++){
            List<Integer> list = hm.get(i);
            for(int num=list.size()-1; num>=0; num--){
                arr.add(list.get(num));
            }
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
    void fillMap(List<List<Integer>> nums, HashMap<Integer, List<Integer>> hm){
        for(int i=0; i<nums.size(); i++){
            for(int j=0; j<nums.get(i).size(); j++){
                if(!hm.containsKey(i+j)){
                    hm.put(i+j, new ArrayList<>());
                }
                List<Integer> temp = hm.get(i+j);
                temp.add(nums.get(i).get(j));
                hm.put(i+j, temp);
            }
        }
    }
}
