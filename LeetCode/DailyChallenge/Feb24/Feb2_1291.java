package DailyChallenge.Feb24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Feb2_1291 {
    public static void main(String[] args) {
        int low = 1000, high = 13000;
        Feb2_1291 obj = new Feb2_1291();
        System.out.println(obj.sequentialDigits(low, high));
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=9; i++){
            int num=i;
            int nextDigit = i+1;

            while(num<=high && nextDigit<=9){
                num = num * 10 + nextDigit;
                if(low<=num && num<=high){
                    arr.add(num);
                }
                nextDigit++;
            }
        }
        Collections.sort(arr);
        return arr;
    }
}
