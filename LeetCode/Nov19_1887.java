import java.util.Arrays;

public class Nov19_1887 {
    public static void main(String[] args) {
        int[] arr = {5,1,3};
        Nov19_1887 obj = new Nov19_1887();
        System.out.println(obj.reductionOperations(arr));
    }
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int smallest = nums[0];
        int ans=0;
        int pow=0;
        for(int i=1; i<nums.length; ){
            if(smallest == nums[i]){
                i++;
                continue;
            }
            int pointer=i;
            int ways=0;
            while(pointer<nums.length && nums[i]==nums[pointer]){
                ways++;
                pointer++;
            }
            i += ways;
            pow++;
            ans += ways * pow;
        }

        return ans;
    }
}
