package DailyChallenge.Nov;

public class nov9_3133 {
    public static void main(String[] args) {
        int n = 3, x = 4;
        nov9_3133 obj = new nov9_3133();
        System.out.println(obj.minEnd(n, x));
    }
    public long minEnd(int n, int x) {
        long ans = x;
        while(n-->1){
            ans = ((ans + 1) | x);
        }
        return ans;
    }
}
