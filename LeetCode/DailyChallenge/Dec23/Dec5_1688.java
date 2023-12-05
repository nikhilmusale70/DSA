package DailyChallenge.Dec23;

public class Dec5_1688 {
    public static void main(String[] args) {
        Dec5_1688 obj = new Dec5_1688();
        int teams = 4;
        System.out.println(obj.numberOfMatches(teams));
    }
    public int numberOfMatches(int n) {
        return matchesPlayed(n, 0);
    }

    int matchesPlayed(int n, int matchesPlayed){
        if(n==1){
            return matchesPlayed;
        }
        int teams;
        if(n%2==0){
            //even
            teams = n/2;
        }
        else{
            teams = n/2 +1;
        }
        return matchesPlayed(teams, matchesPlayed+n/2);
    }
}
