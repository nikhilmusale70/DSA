import java.util.HashMap;

public class Temp {
    public static void main(String[] args) {
        System.out.println("ehlloo");
        Temp obj = new Temp();
        int[] arr = {24,22,46,40,26,28,10,47,4,3,26,26};
        System.out.println(obj.getPairsCount(arr, arr.length, 50));
    }
    //   int[] arr = {24,22,46,40,26,28,10,47,26,26,4,3};
    int getPairsCount(int[] arr, int n, int k) {

        int count = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(26, 1);
        for(int i=n-1;i>=0;i--){
            if(hash.containsKey(k-arr[i])) {
                count += hash.get(k-arr[i]);
            }

            hash.put(arr[i], hash.getOrDefault(hash.get(arr[i]), 1) + 1);
        }
        return count;
    }
}