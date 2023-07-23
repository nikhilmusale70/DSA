package Maths4Combimatrics;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        ExcelColumnTitle obj = new ExcelColumnTitle();
        System.out.println(obj.getTitle(53));
    }
//    public String convertToTitle(int A) {
//
//    }
    public String getTitle(int A){
        String res="";

        while (A>0){
            int temp = (A-1)%26;
            res = (char)('A'+temp)+res;
            A=(A-1)/26;
        }

        return res;
    }
}
