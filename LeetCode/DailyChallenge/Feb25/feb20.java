package DailyChallenge.Feb25;

public class feb20 {
    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        feb20 obj = new feb20();
        System.out.println(obj.findDifferentBinaryString(nums));
    }
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            char ch = nums[i].charAt(i);
            sb.append(ch=='0'?'1':'0');
        }
        return sb.toString();
    }
}
