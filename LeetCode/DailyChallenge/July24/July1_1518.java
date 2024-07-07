package DailyChallenge.July24;

public class July1_1518 {
    public static void main(String[] args) {
        int numBottles = 15, numExchange = 4;
        July1_1518 obj = new July1_1518();
        System.out.println(obj.numWaterBottles(numBottles, numExchange));
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        //we can drink num bottles in total
        int ans = numBottles;

        //we can exchange numExchange to refill
        while(numBottles>=numExchange){
            int refillBottle = numBottles / numExchange;
            ans += refillBottle;
            int emptyBottle = numBottles % numExchange;
            numBottles = refillBottle+emptyBottle;
        }
        return ans;
    }
}
