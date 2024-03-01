package DailyChallenge.March24;

public class March1_2864 {
    public static void main(String[] args) {
        String str = "0101";
        March1_2864 obj = new March1_2864();
        System.out.println(obj.maximumOddBinaryNumber(str));
    }
    public String maximumOddBinaryNumber(String s) {
        int count1 = 0, count0 = 0;
        for(char ch: s.toCharArray()){
            if(ch=='1') count1++;
            else count0++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<count1-1; i++){
            sb.append("1");
        }
        for(int i=0; i<count0; i++){
            sb.append("0");
        }
        sb.append("1");
        return sb.toString();
    }
}
