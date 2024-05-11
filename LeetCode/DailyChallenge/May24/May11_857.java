package DailyChallenge.May24;

public class May11_857 {
    public static void main(String[] args) {
        int[] quality = {10,20,5};
        int [] wage = {70,50,30};
        int k = 2;
        May11_857 obj = new May11_857();
        System.out.println(obj.mincostToHireWorkers(quality, wage, k));
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ans = Double.MAX_VALUE;
        for(int i = 0; i < quality.length; i++) {
            ans = Math.min(ans, wage[i] + helper(quality, wage, k - 1, 0, i, (double) wage[i] / quality[i], new Double[quality.length][k + 1]));
        }
        return ans;
    }

    double helper(int[] quality, int[] wage, int k, int idx, int selected, double ratio, Double[][] memo) {
        if (k == 0) {
            return 0;
        }
        if (idx == quality.length) {
            return Integer.MAX_VALUE;
        }
        if (memo[idx][k] != null) {
            return memo[idx][k];
        }

        double take = Double.MAX_VALUE;
        if (idx != selected && quality[idx] * ratio >= wage[idx]) {
            take = quality[idx] * ratio + helper(quality, wage, k - 1, idx + 1, selected, ratio, memo);
        }
        double dontTake = helper(quality, wage, k, idx + 1, selected, ratio, memo);

        double result = Math.min(take, dontTake);

        // Memoize the result
        memo[idx][k] = result;

        return result;
    }
}
