package DailyChallenge.Jan24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Jan16_380 {
    public static void main(String[] args) {
        Random rn = new Random();
    }
    class RandomizedSet {
        HashMap<Integer, Integer> map;
        ArrayList<Integer> nums;

        public RandomizedSet() {
            map = new HashMap<>();
            nums = new ArrayList<>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            map.put(val, nums.size()-1);
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            int idx = map.get(val);
            nums.remove(idx);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            Random rn = new Random();
            return nums.get(rn.nextInt(nums.size()));
        }
    }
}
