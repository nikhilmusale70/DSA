package DailyChallenge.Aug24;

public class Aug7_273 {
    private static final String[] belowTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    private static final String[] belowTwenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] belowHundred = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public static void main(String[] args) {
        int num = 12345;
        Aug7_273 obj = new Aug7_273();
        System.out.println(obj.numberToWords(num));
    }

    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        if(num<10){
            return belowTen[num];
        }
        if(num<20){
            return belowTwenty[num-10];
        }
        if(num<100){
            return belowHundred[num/10] + (num % 10 == 0?" ": " " + numberToWords(num%10));
        }
        if(num<1000){
            return belowTen[num/100] + " Hundred" + (num % 100 == 0?" ": " " + numberToWords(num%100));
        }
        if(num<1000000){
            return numberToWords(num/1000) + " Thousand" + (num % 1000 == 0?" ": " " + numberToWords(num%1000));
        }
        if(num<1000000000){
            return numberToWords(num/1000000) + " Million" + (num % 1000000 == 0?" ": " " + numberToWords(num%1000000));
        }
        return numberToWords(num/1000000000) + " Billion" + (num % 1000000000 == 0?" ": " " + numberToWords(num%1000000000));
    }
}
