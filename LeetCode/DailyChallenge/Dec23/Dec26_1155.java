package DailyChallenge.Dec23;

public class Dec26_1155 {
    public static void main(String[] args) {
        Dec26_1155 obj = new Dec26_1155();
        System.out.println(obj.numRollsToTarget(3,6,7));
    }
    public int numRollsToTarget(int n, int k, int target) {
        if(n==1){
            return 1;
        }
        return helper(target, k, n);
    }

    int helper(int target, int k, int stepsRemaning){
        if(stepsRemaning==1 && target<=k){
            return 1;
        }
        if(stepsRemaning==0 || target==0){
            return 0;
        }

        int ans =0;
        for(int i=1; i<=k; i++){
            if (target - i >= 0) {
                ans += helper(target - i, k, stepsRemaning - 1);
            }
        }
        return ans;
    }
}
