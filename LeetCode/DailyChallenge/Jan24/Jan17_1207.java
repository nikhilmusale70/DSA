package DailyChallenge.Jan24;

import java.util.HashSet;

public class Jan17_1207 {
    public static void main(String[] args) {
        int[] arr= {1,2,2,1,1,3};
        Jan17_1207 obj = new Jan17_1207();
        System.out.println(obj.uniqueOccurrences(arr));
    }
    public boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];
        boolean[] numUsed = new boolean[1000+1];

        for(int i: arr){
            freq[i+1000]++;
        }
        for(int i: arr){
            int count = freq[i+1000];
            freq[i+1000]=0;
            if(count>0){
                if(numUsed[count]) return false;
                numUsed[count]=true;
            }
        }
        return true;
    }
}
