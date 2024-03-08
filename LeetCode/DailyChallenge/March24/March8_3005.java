package DailyChallenge.March24;

public class March8_3005 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,1,2};
        March8_3005 obj = new March8_3005();
        System.out.println(obj.maxFrequencyElements(nums));
    }
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        for(int num: nums){
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }

        int ans = 0;
        for(int i=1; i<=100; i++){
            if(maxFreq == freq[i]){
                ans+=maxFreq;
            }
        }
        return ans;
    }
}

