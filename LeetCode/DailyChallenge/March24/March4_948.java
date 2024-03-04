package DailyChallenge.March24;

import java.util.Arrays;

public class March4_948 {
    public static void main(String[] args) {
        int[] arr = {100,200,300,100,50,400};
        int power = 200;
        March4_948 obj = new March4_948();
        System.out.println(obj.bagOfTokensScore(arr, power));
    }
    public int bagOfTokensScore(int[] tokens, int power) {
        // Sort the tokens array to facilitate efficient token selection.
        Arrays.sort(tokens);

        // Initialize pointers for the minimum and maximum indices of the tokens array.
        int leftPointer = 0; // Points to the smallest token.
        int rightPointer = tokens.length - 1; // Points to the largest token.

        // Initialize variables to track the current score and the maximum score achieved.
        int maxScore = 0;
        int currentScore = 0;

        // Iterate through the tokens array until the left pointer crosses or meets the right pointer.
        while (leftPointer <= rightPointer) {
            // If the token at the left pointer is affordable with the current power,
            // spend the power to gain the token and increase the current score.
            if (tokens[leftPointer] <= power) {
                power -= tokens[leftPointer];
                currentScore++;
                leftPointer++;
            }
            // If the token at the left pointer is unaffordable and there are tokens to potentially trade back,
            // trade the largest token for power to potentially regain lost score.
            else {
                if (currentScore > 0) {
                    power += tokens[rightPointer];
                    currentScore--;
                }
                rightPointer--;
            }
            // Update the maximum score achieved so far.
            maxScore = Math.max(maxScore, currentScore);
        }

        // Return the maximum score achieved.
        return maxScore;
    }

}
