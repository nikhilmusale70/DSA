package DailyChallenge.Aug24;

public class Aug1_2678 {
    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        Aug1_2678 obj = new Aug1_2678();
        System.out.println(obj.countSeniors(details));
    }

    public int countSeniors(String[] details) {
        int peopleGreaterThan60=0;
        for(String detail: details){
            if(detail.charAt(11)>'6' || detail.charAt(11)=='6'&&detail.charAt(12)>'0'){
                peopleGreaterThan60++;
            }
        }
        return peopleGreaterThan60;
    }
}
