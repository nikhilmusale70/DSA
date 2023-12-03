package DailyChallenge.Dec23;

public class Dec3_1266 {
    public static void main(String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};
        Dec3_1266 obj = new Dec3_1266();
        System.out.println(obj.minTimeToVisitAllPoints(points));
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for(int i=0; i<points.length-1; i++){
            int x = points[i][0];
            int y = points[i][1];
            int desX = points[i+1][0];
            int desY = points[i+1][1];

            ans += Math.max(Math.abs(desX - x), Math.abs(desY - y));
        }
        return ans;
    }
}
