package DailyChallenge.March24;

import java.util.Arrays;
import java.util.Comparator;

public class March18_452 {
    public static void main(String[] args) {
        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        March18_452 obj = new March18_452();
        System.out.println(obj.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        // Sort the points array based on the start position of each balloon
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int arrows = 1; // Initialize the arrow count to 1 as we always need at least one arrow
        int end = points[0][1]; // Initialize the end position with the end position of the first balloon

        // Iterate through the points array to find the minimum number of arrows needed
        for (int i = 1; i < points.length; i++) {
            int currentStart = points[i][0]; // Start position of the current balloon
            int currentEnd = points[i][1]; // End position of the current balloon

            // If there's a gap between the end position and the start position of the current balloon,
            // increment arrow count and update end position
            if (end < currentStart) {
                arrows++;
                end = currentEnd;
            } else {
                // If there's an overlap, update the end position to the minimum of the current end position
                // and the existing end position
                end = Math.min(end, currentEnd);
            }
        }

        return arrows; // Return the minimum number of arrows needed
    }
}
