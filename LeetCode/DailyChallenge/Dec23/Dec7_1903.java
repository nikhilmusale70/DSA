package DailyChallenge.Dec23;

public class Dec7_1903 {
    public static void main(String[] args) {
        Dec7_1903 obj = new Dec7_1903();
        System.out.println(obj.largestOddNumber("2356"));
    }


    public String largestOddNumber(String num) {
        int end = num.length()-1;
        while(end>=0){
            if(Integer.parseInt(num.charAt(end)+"")%2 != 0){
                break;
            }
            end--;
        }

        return num.substring(0, end+1);
    }
}
