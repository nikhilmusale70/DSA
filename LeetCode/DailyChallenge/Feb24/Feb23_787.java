package DailyChallenge.Feb24;

public class Feb23_787 {
    public int findCheapestPrice(int numberOfCities, int[][] flights, int sourceCity, int destinationCity, int maxStops) {
        // Array to store current distances from source city to all other cities
        int[] currentDistances = new int[numberOfCities];
        // Array to store distances from source city to all other cities in the previous iteration
        int[] previousDistances = new int[numberOfCities];

        // Initialize distance arrays
        for(int i = 0; i < numberOfCities; i++) {
            previousDistances[i] = Integer.MAX_VALUE;
            currentDistances[i] = Integer.MAX_VALUE;
        }

        // Iterate for the maximum number of stops allowed
        for(int stop = 0; stop <= maxStops; stop++) {
            // Set the distance from source city to itself as 0 in the previous distances array
            previousDistances[sourceCity] = 0;

            // Iterate over each flight
            for(int[] flight : flights) {
                int start = flight[0], end = flight[1], cost = flight[2];

                // If there was no path to the starting city in the previous iteration, skip
                if(previousDistances[start] == Integer.MAX_VALUE) continue;

                // Calculate the new distance to the destination city via the current flight
                if(previousDistances[start] + cost < currentDistances[end])
                    currentDistances[end] = previousDistances[start] + cost;
            }

            // Copy the current distances to the previous distances array for the next iteration
            copyArray(currentDistances, previousDistances);
        }

        // Return the minimum distance to the destination city if reachable, otherwise return -1
        return currentDistances[destinationCity] == Integer.MAX_VALUE ? -1 : currentDistances[destinationCity];
    }

    // Method to copy values from one array to another
    private void copyArray(int[] source, int[] destination) {
        for(int i = 0; i < source.length; i++)
            destination[i] = source[i];
    }

}
