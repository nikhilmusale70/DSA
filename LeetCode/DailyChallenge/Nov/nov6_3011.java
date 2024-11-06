package DailyChallenge.Nov;

public class nov6_3011 {
    public static void main(String[] args) {
        int[] arr = {18,3,8};
        nov6_3011 obj = new nov6_3011();
        System.out.println(obj.canSortArray(arr));
    }
    public boolean canSortArray(int[] nums) {
        int[] bits = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            bits[i] = findSetBits(nums[i]);
        }

        int prevMax = Integer.MIN_VALUE;
        int currMin = nums[0], currMax = nums[0];
        for(int i=1; i<bits.length; i++){
            if(bits[i]==bits[i-1]){
                currMin = Math.min(currMin, nums[i]);
                currMax = Math.max(currMax, nums[i]);
                continue;
            }
            if(currMin<prevMax){
                return false;
            }
            prevMax = currMax;
            currMin = nums[i];
            currMax = nums[i];
        }
        if(currMin<prevMax){
            return false;
        }

        return true;
    }

    int findSetBits(int num){
        int setBit = 0;
        for(int i=0; i<31; i++){
            if((num&(1<<i)) != 0)
                setBit++;
        }
        return setBit;
    }
}
