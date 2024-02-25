package DailyChallenge.Feb24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Feb25_2709 {
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) return true;

        Map<Integer, Integer> dsu = new HashMap<>();

        for (int num : nums) {
            // if num is 1 GCD with any other number will be 1 so return false.
            if (num == 1) return false;

            // Get all unique [pri]
            Set<Integer> factors = findFactors(num);

            // First time visiting this node, it will be a separate component itself.
            if (!dsu.containsKey(num)) dsu.put(num, num);

            // For all prime factors merge factor and num.
            for (int factor : factors) {
                // If first time visiting this factor, it will be a separate component itself.
                if (!dsu.containsKey(factor)) dsu.put(factor, factor);

                // merge num and factor in one component.
                union(dsu, num, factor);
            }
        }

        // collect parent of all the components.
        Set<Integer> components = new HashSet<>();
        for (int num : nums) {
            components.add(find(dsu, num));
        }

        // if all nodes are part of same component components count will be 1.
        return components.size() == 1;
    }

    // Union operation to merge two components.
    private void union(Map<Integer, Integer> dsu, int num1, int num2) {
        int p1 = find(dsu, num1);
        int p2 = find(dsu, num2);

        dsu.put(p1, p2);
    }

    // Find operation to get the parent of DSU node.
    private int find(Map<Integer, Integer> dsu, int num) {
        if (dsu.getOrDefault(num, num) != num) {
            dsu.put(num, find(dsu, dsu.get(num)));
        }

        return dsu.getOrDefault(num, num);
    }

    // Method to get all the unique factors of the number.
    private HashSet<Integer> findFactors(int number) {
        HashSet<Integer> primeFactors = new HashSet<>();

        while (number % 2 == 0) {
            primeFactors.add(2);
            number /= 2;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }

        if (number > 2) {
            primeFactors.add(number);
        }

        return primeFactors;
    }
}
