package DailyChallenge.Dec23;

public class Dec4_2264 {
    public static void main(String[] args) {
        String str = "6777133339";
        Dec4_2264 obj = new Dec4_2264();
        System.out.println(obj.largestGoodInteger(str));
    }
    public String largestGoodInteger(String num) {
        String ans = "";
        for(int i=0; i<num.length()-2; i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)){
                //potential ans
                if(ans.length()==0){
                    ans = num.substring(i, i+3);
                }
                else{
                    int temp = Integer.parseInt(num.substring(i, i+3));
                    int an = Integer.parseInt(ans);

                    if(temp>an){
                        ans = temp + "";
                    }
                }
            }
        }
        return ans;
    }
}
