package DailyChallenge.oct24;

import java.util.ArrayList;
import java.util.List;

public class oct12_2406 {
    public static void main(String[] args) {
        int[][] intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        oct12_2406 obj = new oct12_2406();
        System.out.println(obj.minGroups(intervals));
    }

    public int minGroups(int[][] intervals) {
        List<int[]> interval = new ArrayList<>();
        for(int[] slot: intervals){
            int start = slot[0];
            int end = slot[1];
            interval.add(new int[]{start, 1});
            interval.add(new int[]{end+1, -1});
        }

        interval.sort((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });

        int ans = 0;
        int curr = 0;
        for(int[] slots: interval){
            curr += slots[1];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
