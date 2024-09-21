package DailyChallenge.sept24;

import java.util.Arrays;

public class sept18_179 {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        sept18_179 obj = new sept18_179();
        System.out.println(obj.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for(int i=0; i<numbers.length; i++){
            numbers[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numbers, (a,b)->(b+a).compareTo(a+b));
        if(numbers[0].equals("0")){
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        for(String str: numbers){
            ans.append(str);
        }
        return ans.toString();
    }
}
