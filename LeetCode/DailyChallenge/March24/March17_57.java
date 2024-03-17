package DailyChallenge.March24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class March17_57 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        March17_57 obj = new March17_57();
        System.out.println(Arrays.deepToString(obj.insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        boolean inserted = false;

        for (int[] interval : intervals) {
            int currentStart = interval[0];
            int currentEnd = interval[1];

            // If the current interval ends before the new interval starts,
            // or if the new interval has been inserted already, add the current interval to the result.
            if (currentEnd < newStart || inserted) {
                mergedIntervals.add(interval);
                continue;
            }

            // Merge intervals if there is overlap
            newStart = Math.min(newStart, currentStart);
            if (newEnd < currentStart) {
                // If there's a gap between the new interval and the current interval, add the new interval
                mergedIntervals.add(new int[]{newStart, newEnd});
                mergedIntervals.add(interval);
                inserted = true;
            } else if (newEnd <= currentEnd) {
                // If the new interval is fully contained within the current interval
                // or if it overlaps with the current interval, merge them
                mergedIntervals.add(new int[]{newStart, currentEnd});
                inserted = true;
            }
        }

        // If the new interval hasn't been inserted yet, add it to the end
        if (!inserted) {
            mergedIntervals.add(newInterval);
        }

        // Convert List<int[]> to int[][]
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

}
