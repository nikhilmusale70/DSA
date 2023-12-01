package DailyChallenge.Nov23;


public class Nov30_1611 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println( (1<<1 & n) == 0);
        Nov30_1611 obj = new Nov30_1611();
        int number = 3;
        System.out.println(obj.minimumOneBitOperations(number));
    }

    public int minimumOneBitOperations(int n) {
        int[] f = new int[32];
        f[0] = 1;
        for(int i=1; i<32; i++){
            f[i] = f[i-1]*2+1;
        }

        boolean d = true;
        int ans = 0;
        for(int i=31; i>=0; i--){
            if(!checkIfBitIsSet(i, n)){
                continue;
            }
            if(d) ans += f[i];
            else ans -= f[i];
            d = !d;
        }
        return ans;
    }

    boolean checkIfBitIsSet(int idx, int num){
        if( ((1<<idx)&num) == 0){
            return false;
        }
        return true;
    }
}
