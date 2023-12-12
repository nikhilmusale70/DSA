package DailyChallenge.Dec23;

public class Dec12_1464 {
    public static void main(String[] args) {
        Dec12_1464 obj = new Dec12_1464();
        System.out.println(obj.maxProduct(new int[]{3,4,5,2}));
    }
    public int maxProduct(int[] nums) {
        int max = 0;
        int secondMax = 0;
        for(int num: nums){
            if(num>max){
                secondMax = max;
                max = num;
                continue;
            }
            if(num>secondMax){
                secondMax = num;
            }
        }
        return (max-1) * (secondMax-1);
    }
}
