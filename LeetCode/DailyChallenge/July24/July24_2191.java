package DailyChallenge.July24;

import java.util.Arrays;

public class July24_2191 {
    public static void main(String[] args) {
        int[] mapping = {8,9,4,0,2,1,3,5,7,6}, nums = {991,338,38};
        July24_2191 obj = new July24_2191();
        System.out.println(Arrays.toString(obj.sortJumbled(mapping, nums)));
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] mappedValues = new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            mappedValues[i][0] = nums[i];
            mappedValues[i][1] = mappedNumber(nums[i], mapping);
        }

        Arrays.sort(mappedValues, (a,b)-> a==b?
                Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for(int i=0; i<nums.length; i++){
            nums[i] = mappedValues[i][0];
        }
        return nums;
    }

    int mappedNumber(int num, int[] mapping){
        char[] numb = Integer.toString(num).toCharArray();
        for(int i=0; i<numb.length; i++){
            int n = Character.getNumericValue(numb[i]);
            numb[i] = Character.forDigit(mapping[n], 10);
        }
        return Integer.parseInt(new String(numb));
    }
}
