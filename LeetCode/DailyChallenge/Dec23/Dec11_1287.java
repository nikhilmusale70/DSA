package DailyChallenge.Dec23;

public class Dec11_1287 {
    public static void main(String[] args) {
        Dec11_1287 obj = new Dec11_1287();
        System.out.println(obj.findSpecialInteger(new int[]{1,2,3,4,4,4,4,5}));
    }
    public int findSpecialInteger(int[] arr) {
        int size = arr.length/4;
        for(int i=0; i<arr.length-size; i++){
            if(arr[i] == arr[i+size]){
                return arr[i];
            }
        }
        return -1;
    }
}
