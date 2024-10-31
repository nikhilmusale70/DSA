package DailyChallenge.oct24;

import Utils.util;

import java.util.*;

public class oct31_2463 {
    public static void main(String[] args) {
        int[] robot = {4,0,6};
        int[][] factory = {{2,2},{6,2}}; //position then location
        oct31_2463 obj = new oct31_2463();
        System.out.println(obj.minimumTotalDistance(util.convertToArrayList(robot), factory));
    }

    long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robot positions and expand factory positions based on capacity
        Collections.sort(robot);
        List<Integer> factoryPositions = new ArrayList<>();


        for (int[] currFactory : factory) {
            for (int i = 0; i < currFactory[1]; i++) {
                factoryPositions.add(currFactory[0]);
            }
        }
        Collections.sort(factoryPositions);
        dp = new long[robot.size()][factoryPositions.size()];
        for(long[] row: dp){
            Arrays.fill(row, -1);
        }

        // Calculate minimum total distance using recursive helper
        return calculateMinDistance(0, 0, robot, factoryPositions);
    }

    private long calculateMinDistance(int robotIndex, int factoryIndex, List<Integer> robots, List<Integer> factories) {
        // Base cases: all robots assigned or no more factories
        if (robotIndex == robots.size()) return 0;
        if (factoryIndex == factories.size()) return Long.MAX_VALUE;

        if(dp[robotIndex][factoryIndex] != -1) return dp[robotIndex][factoryIndex];

        // Option 1: Assign current robot to current factory
        long repair = Math.abs(robots.get(robotIndex) - factories.get(factoryIndex)) +
                calculateMinDistance(robotIndex + 1, factoryIndex + 1, robots, factories);

        // Option 2: Skip current factory and try the next one
        long skip = calculateMinDistance(robotIndex, factoryIndex + 1, robots, factories);

        // Return the minimum distance of both options
        return dp[robotIndex][factoryIndex] = Math.min(repair, skip);
    }


}
