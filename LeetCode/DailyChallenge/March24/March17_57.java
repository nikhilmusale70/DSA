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
        // Initialize a list to store merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();

        // Extract the start and end values of the new interval
        int newStart = newInterval[0], newEnd = newInterval[1];
        // Initialize a flag to track whether the new interval has been inserted
        boolean inserted = false;

        // Iterate through each interval in the input array
        for (int[] currentInterval : intervals) {
            // Extract the start and end values of the current interval
            int currentStart = currentInterval[0], currentEnd = currentInterval[1];

            // If the end of the current interval is before the start of the new interval,
            // or if the new interval has been inserted already, add the current interval
            // to the list of merged intervals
            if (currentEnd < newStart || inserted) {
                mergedIntervals.add(new int[]{currentStart, currentEnd});
                continue;
            }

            // Update the start of the new interval to be the minimum of its current start
            // and the start of the current interval
            newStart = Math.min(newStart, currentStart);

            // If the end of the new interval is before the start of the current interval,
            // add the new interval followed by the current interval to the list of merged intervals
            if (newEnd < currentStart) {
                mergedIntervals.add(new int[]{newStart, newEnd});
                mergedIntervals.add(new int[]{currentStart, currentEnd});
                inserted = true;
                continue;
            }

            // If the end of the new interval is before or equal to the end of the current interval,
            // update the end of the new interval to be the end of the current interval
            if (newEnd <= currentEnd) {
                mergedIntervals.add(new int[]{newStart, currentEnd});
                inserted = true;
            }
        }

        // If the new interval hasn't been inserted yet, add it to the list of merged intervals
        if (!inserted) {
            mergedIntervals.add(new int[]{newStart, newEnd});
        }

        // Convert the list of merged intervals to a 2D array and return it
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
