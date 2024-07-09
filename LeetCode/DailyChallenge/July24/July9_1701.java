package DailyChallenge.July24;

public class July9_1701 {
    public static void main(String[] args) {
        July9_1701 obj = new July9_1701();
//        int[][] customers = {{1,2},{2,5},{4,3}};
        int[][] customers = {{5,2},{5,4},{10,3},{20,1}};
        System.out.println(obj.averageWaitingTime(customers));
    }
    public double averageWaitingTime(int[][] customers) {
        int ans = 0;
        int currTime = 1;
        for(int[] cus: customers){
            currTime = Math.max(currTime, cus[0]);
            int finish = cus[1] + currTime;
            currTime = finish;
            int waitingTime = finish - cus[0];
            ans += waitingTime;
        }
        return (double) ans /customers.length;
    }
}
