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
        for(int i=0; i<quality.length; i++){
            ans = Math.min(ans, wage[i] + helper(quality, wage, k-1, i+1, (double) wage[i] /quality[i]));
        }
        return ans;
    }

    double helper(int[] quality, int[] wage, int k, int idx, double ratio){
        if (k == 0) {
            return 0;
        }
        if(idx == quality.length){
            return Integer.MAX_VALUE;
        }

        double take = Double.MAX_VALUE;
        if(quality[idx]*ratio>=wage[idx]){
            //only then we can hire
            take = quality[idx]*ratio + helper(quality, wage, k-1, idx+1, ratio);
        }
        double dontTake = helper(quality, wage, k, idx+1, ratio);

        return Math.min(take, dontTake);
    }
}
