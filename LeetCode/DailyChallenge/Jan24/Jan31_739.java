package DailyChallenge.Jan24;

import java.util.Arrays;
import java.util.Stack;

public class Jan31_739 {
    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        Jan31_739 obj = new Jan31_739();
        System.out.println(Arrays.toString(obj.dailyTemperatures(arr)));
    }

    class Pair{
        int num;
        int idx;
        Pair(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stk = new Stack<>();
        int[] ans = new int[temperatures.length];
        ans[temperatures.length-1] = 0;
        stk.push(new Pair(temperatures[temperatures.length-1], temperatures.length-1));

        for(int i=temperatures.length-2; i>=0; i--){
            int num = temperatures[i];
            while(!stk.isEmpty() && stk.peek().num<=num){
                stk.pop();
            }
            if(stk.isEmpty()){
                ans[i] = 0;
            }
            else{
                ans[i] = stk.peek().idx-i;
            }
            stk.push(new Pair(num, i));

        }
        return ans;
    }
}
