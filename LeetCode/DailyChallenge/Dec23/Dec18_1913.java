package DailyChallenge.Dec23;

public class Dec18_1913 {
    public static void main(String[] args) {
        Dec18_1913 obj = new Dec18_1913();
        int[] nums = {5,6,2,7,4};

        System.out.println(obj.maxProductDifference(nums));
    }

    public int maxProductDifference(int[] nums) {
        int max=0, secondMax=0;
        int min=(int)1e8, secondMin=(int)1e8;

        for(int num: nums){
            if(num>max){
                secondMax = max;
                max = num;
            }
            else if(num>secondMax){
                secondMax = num;
            }

            if(num<min){
                secondMin = min;
                min = num;
            }
            else if(num<secondMin){
                secondMin = num;
            }
        }

        return (max*secondMax) - (min*secondMin);
    }
}
