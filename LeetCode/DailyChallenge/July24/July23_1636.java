package DailyChallenge.July24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class July23_1636 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        July23_1636 obj = new July23_1636();
        System.out.println(Arrays.toString(obj.frequencySort(nums)));
    }
    public int[] frequencySort(int[] nums) {
        int[][] freqArray = new int[201][2];
        for(int num: nums){
            freqArray[num+100][1]++;
        }
        for(int i=0; i<201; i++){
            freqArray[i][0] = i-100;
        }

        Arrays.sort(freqArray, (a,b)->{
            if(a[1]==b[1])
                return Integer.compare(b[0], a[0]);
            else{
                return Integer.compare(a[1],b[1]);
            }
        });

        int idx = 0;
        for(int i=0; i<201; i++){
            for(int j=0; j<freqArray[i][1]; j++){
                nums[idx++] = freqArray[i][0];
            }
        }
        return nums;
    }
}
