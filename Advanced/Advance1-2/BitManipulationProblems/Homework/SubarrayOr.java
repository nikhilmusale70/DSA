package BitManipulationProblems.Homework;

public class SubarrayOr {
    public static void main(String[] args) {

    }
    public int solve(int[] A) {
        int ans = 0;
        int n = A.length;
        int totalSubArray = (n*(n+1))/2;

        for(int i = 0 ; i < 32 ; i++){
            int count = 0;
            int subarray = 0;

            for(int j = 0 ; j < A.length ; j++){
                if(!checkSetBit(A[j],i)){
                    count++;
                }
                if(checkSetBit(A[j],i) || j == n-1){
                    subarray += (count*(count+1))/2;
                    count = 0;
                }
            }
// subarray += (count * (count+1))/2;
            ans = (ans + ((totalSubArray - subarray) * (int)Math.pow(2,i))) % 1000000007;

        }
        return ans;
    }

    public boolean checkSetBit(int A, int i){
        if(((A>>i)&1) == 1){
            return true;
        }
        return false;
    }
}
