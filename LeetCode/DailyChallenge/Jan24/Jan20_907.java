package DailyChallenge.Jan24;

public class Jan20_907 {
    public static void main(String[] args) {
        int[] arr = {3,1,4,1};
        //593
        Jan20_907 obj = new Jan20_907();
        System.out.println(obj.sumSubarrayMins(arr));
    }

    int mod = (int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;

        for(int i=0; i<arr.length; i++){
            long leftCount=0, rightCount=0;
            int left = i-1;
            int right = i+1;

            if(i>=0){
                //go only right
                rightCount = goRightAndFindContri(arr, right, arr[i]);
            }
            if(i<arr.length){
                //go only left
                leftCount = goLeftAndFindContri(arr, left, arr[i]);
            }
            ans += ((((leftCount+1)*(rightCount+1))%mod) * arr[i])%mod;
            ans %= mod;
        }
        return (int)ans;
    }
    int goLeftAndFindContri(int[] arr, int idx, int curr){
        int count = 0;
        while(idx>=0 && arr[idx]>=curr){
            count++;
            idx--;
        }
        return count;
    }
    int goRightAndFindContri(int[] arr, int idx, int curr){
        int count = 0;
        while(idx<arr.length && arr[idx]>curr){
            count++;
            idx++;
        }
        return count;
    }
}
