package Stacks2;

import java.util.Arrays;
import java.util.Stack;

public class MaxAndMin {
    public static void main(String[] args) {
        MaxAndMin obj = new MaxAndMin();
        int[] A = {994390, 986616, 976849, 979707, 950477, 968402, 992171, 937674, 933065, 960863, 980981, 937319, 951236, 959547, 991052, 991799, 992213, 941294, 978103, 997198, 960759, 988476, 963517, 980366, 921767, 979757, 977912, 983761, 981869, 947454, 930202, 999086, 973538, 999798, 996446, 944001, 974217, 951595, 942688, 975075, 970973, 970130, 897109, 927660, 862233, 997130, 986068, 954098, 978175, 889682, 988973, 996036, 969675, 985751, 977724, 881538, 988613, 924230, 906475, 915565, 986952, 975702, 994316, 964011, 986848, 983699, 949076, 989673, 981788, 929094, 988310, 926471, 994763, 999736, 980762, 973560, 996622, 934475, 998365, 966255, 998697, 998700, 911868, 983245, 996382, 996992, 953142, 994104, 987303, 853837, 960626, 904203, 998063, 977596, 977868, 996012, 946345, 949255, 988138, 996298, 954933, 965036, 886976, 998628, 990878, 953725, 916744, 985233, 919661, 970903, 986066};
        System.out.println(obj.solve(A));
    }

    public int solve(int[] A) {
        long mod = 1000000007;
        int[] leftSmallNearElem = leftSmallestIndex(A);
        int[] rightSmallNearElem = rightSmallestIndex(A);
        int[] leftGreatNearElem = leftGreatIndex(A);
        int[] rightGreatNearElem = rightGreatIndex(A);

        long value=0;
        long minConti = 0;
        long maxConti = 0;

        //contri for min and max
        for (int i=0; i<A.length; i++){
            long minrightBlocks = rightSmallNearElem[i]==-1? A.length-i-1 : rightSmallNearElem[i]-i-1;
            long minleftBlocks = leftSmallNearElem[i]==-1? i : i-leftSmallNearElem[i]-1;
            minConti += A[i]*((minleftBlocks+1)*(minrightBlocks+1));

            long maxrightBlocks = rightGreatNearElem[i]==-1? A.length-i-1 : rightGreatNearElem[i]-i-1;
            long maxleftBlocks = leftGreatNearElem[i]==-1? i : i-leftGreatNearElem[i]-1;
            maxConti += A[i]*((maxleftBlocks+1)*(maxrightBlocks+1));

        }
        value = (maxConti-minConti)%mod;

        return (int) value;
    }

    public int[] leftSmallestIndex(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i])
                stk.pop();
            if(stk.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stk.peek();
            stk.push(i);
        }
        return ans;
    }
    public int[] leftGreatIndex(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            while(!stk.isEmpty() && arr[stk.peek()]<=arr[i])
                stk.pop();
            if(stk.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stk.peek();
            stk.push(i);
        }
        return ans;
    }

    public int[] rightSmallestIndex(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i=arr.length-1; i>=0; i--){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i])
                stk.pop();
            if(stk.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stk.peek();
            stk.push(i);
        }
        return ans;
    }
    public int[] rightGreatIndex(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i=arr.length-1; i>=0; i--){
            while(!stk.isEmpty() && arr[stk.peek()]<=arr[i])
                stk.pop();
            if(stk.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stk.peek();
            stk.push(i);
        }
        return ans;
    }
}
