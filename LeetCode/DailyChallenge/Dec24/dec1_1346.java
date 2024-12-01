package DailyChallenge.Dec24;

import java.util.HashSet;

public class dec1_1346 {
    public static void main(String[] args) {
        dec1_1346 obj = new dec1_1346();
        int[] arr = {10,2,5,3};
        System.out.println(obj.checkIfExist(arr));
    }

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num: arr){
            if(hs.contains(2*num) || num%2==0 && hs.contains(num/2)){
                return true;
            }
            hs.add(num);
        }
        return false;
    }
}
