package DailyChallenge.sept24;

import java.util.ArrayList;
import java.util.List;

public class sept27_731 {
    public static void main(String[] args) {

    }
    class MyCalendarTwo {
        private List<int[]> bookings;
        private List<int[]> doubleBookings;

        public MyCalendarTwo() {
            bookings = new ArrayList<>();
            doubleBookings = new ArrayList<>();
        }
        // Helper function to check if two intervals overlap
        boolean doesOverlap(int start1, int end1, int start2, int end2) {
            return Math.max(start1, start2) < Math.min(end1, end2);
        }
        // Helper function to get the overlapping interval
        int[] getOverlappingInterval(int start1, int end1, int start2, int end2) {
            return new int[] { Math.max(start1, start2), Math.min(end1, end2) };
        }

        public boolean book(int start, int end) {
            // Check if the new booking overlaps with any double-booked intervals
            for (int[] booking : doubleBookings) {
                if (doesOverlap(booking[0], booking[1], start, end)) {
                    return false;
                }
            }

            // Check for overlaps with existing bookings
            for (int[] booking : bookings) {
                if (doesOverlap(booking[0], booking[1], start, end)) {
                    // Add overlapping part to doubleBookings
                    doubleBookings.add(getOverlappingInterval(booking[0], booking[1], start, end));
                }
            }

            bookings.add(new int[] { start, end });
            return true;
        }
    }
}
