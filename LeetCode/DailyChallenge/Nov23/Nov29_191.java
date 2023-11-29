package DailyChallenge.Nov23;

public class Nov29_191 {
    public static void main(String[] args) {
        Nov29_191 obj = new Nov29_191();
        int n = 00000000000000000000000000001011;
        System.out.println(obj.hammingWeight(n));
    }
    public int hammingWeight(int n) {
        int ans=0;
        for(int i=0; i<32; i++){
            if(checkIfSet(i, n)){
                ans++;
            }
        }
        return ans;
    }

    boolean checkIfSet(int idx, int n){
        if( ((1<<idx) & n) == 0){
            return false;
        }
        return true;
    }
}
