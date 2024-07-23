package DailyChallenge.July24;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class July22_2418 {
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};

        July22_2418 obj = new July22_2418();
        System.out.println(Arrays.toString(obj.sortPeople(names, heights)));
    }
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> people = new TreeMap<>();
        for (int i=0; i<names.length; i++){
            people.put(heights[i], names[i]);
        }

        int idx = names.length-1;
        String[] ans = new String[names.length];
        for(String name: people.values()){
            ans[idx--] = name;
        }
        return ans;
    }
}
