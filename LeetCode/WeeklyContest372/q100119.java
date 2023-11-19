package WeeklyContest372;

public class q100119 {
    public static void main(String[] args) {
        q100119 obj = new q100119();
        long a = 1;
        long b = 6;
        int n = 3;
//        long a = 12;
//        long b = 5;
//        int n = 4;
        System.out.println(obj.maximumXorProduct(a,b,n));
    }

    public int maximumXorProduct(long a, long b, int n) {
        long equiA = getEquivalentXor(a,n);
        long equiB = getEquivalentXor(b,n);

        long x = equiA | equiB;

        if(x>getHigeshtSetBit(a) || x>getHigeshtSetBit(b)){
            x = a&b;
        }

        return (int) ((a^x) * (b^x));
    }

    long getHigeshtSetBit(long num){
        long equiNum=0;
        for(int i=31; i>=0; i--){
            if(checkIfBitIsSet(num, i)) {
                return i;
            }
        }
        return equiNum;
    }

    long getEquivalentXor(long num, int n){
        long equiNum=0;
        for(int i=0; i<n && i<31; i++){
            if(!checkIfBitIsSet(num, i)) {
                equiNum += (1<<i);
            }
        }
        return equiNum;
    }
    boolean checkIfBitIsSet(long num, int i){
        if( (num & (1<<i))==0){
            return false;
        }
        return true;
    }
}
