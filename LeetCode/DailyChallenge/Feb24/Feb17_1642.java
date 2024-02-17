package DailyChallenge.Feb24;

import java.util.PriorityQueue;

public class Feb17_1642 {
    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladder = 1;

        Feb17_1642 obj = new Feb17_1642();
        System.out.println(obj.furthestBuilding(heights, bricks, ladder));
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // PriorityQueue to keep track of height differences for buildings where ladders were used
        PriorityQueue<Integer> usedLadders = new PriorityQueue<>();

        // Iterate through the buildings
        for (int i = 0; i < heights.length - 1; i++) {
            // Calculate the height difference between the current building and the next building
            int diff = heights[i + 1] - heights[i];

            // If the height difference is non-positive, no resources needed to move to the next building
            if (diff <= 0) {
                continue;
            }

            // If ladders are available, use a ladder to move to the next building without using bricks
            if (ladders > 0) {
                usedLadders.add(diff); // Store the height difference in the priority queue
                ladders--; // Decrement the remaining ladders count
            } else if (!usedLadders.isEmpty() && diff > usedLadders.peek()) {
                // If no ladders are available, lets go in past and see if we could have used bricks instead of ladders in past
                bricks -= usedLadders.remove(); // Replace the smallest ladder with bricks, and use that ladder over here
                usedLadders.add(diff); // Store the height difference in the priority queue
            } else {
                // If no ladders are there, use bricks directly
                bricks -= diff;
            }

            // If bricks become negative, can't move further, return the current index
            if (bricks < 0) {
                return i;
            }
        }

        // If all buildings can be reached, return the index of the last building
        return heights.length - 1;
    }

}
