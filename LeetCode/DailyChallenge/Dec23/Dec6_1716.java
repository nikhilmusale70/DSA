package DailyChallenge.Dec23;

public class Dec6_1716 {
    public static void main(String[] args) {
        Dec6_1716 obj = new Dec6_1716();
        int n = 20;
        System.out.println(obj.totalMoney(n));
    }

    public int totalMoney(int n) {
        int week = n/7 +1;
        int ans = 0;
        int daysLeft = n%7;
        ans += doAdd(week, daysLeft);

        while(week>1){
            ans += 21 + 7*(week-1);
            week--;
        }
        return ans;
    }

    int doAdd(int start, int daysLeft){
        int ans = 0;
        while(daysLeft>0){
            ans += start++;
            daysLeft--;
        }

        return ans;
    }
}
