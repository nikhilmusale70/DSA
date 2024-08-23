package DailyChallenge.Aug24;

public class Aug22_476 {
    public static void main(String[] args) {
        int num = 2;
        Aug22_476 obj = new Aug22_476();

        System.out.println(obj.findComplement(num));
    }

    public int findComplement(int num) {
        int highestSetBit = 30;
        for( ; highestSetBit>=0; highestSetBit--){
            if(checkSetBit(highestSetBit, num)){
                break;
            }
        }
        highestSetBit++;
        int mask = (1<<highestSetBit) - 1;
        return num ^ mask;
    }

    boolean checkSetBit(int idx, int num){
        return ((1 << idx) & num) != 0;
    }
}
