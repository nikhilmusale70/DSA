package DailyChallenge.Nov;

public class nov15_1574 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,4,2,3,5};
        nov15_1574 obj = new nov15_1574();
        System.out.println(obj.findLengthOfShortestSubarray(arr));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int right = arr.length-1;
        while(right>0 && arr[right-1]<=arr[right]){
            right--;
        }
        int ans = right;
        int left = 0;
        while(left<right && arr[left]<=arr[left+1]){
            while (right<arr.length && arr[left] > arr[right]){
                right++;
            }
            ans = Math.min(ans, right-left+1);
        }
        return ans;
    }


}
