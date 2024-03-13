package DailyChallenge.March24;

public class March13_2485 {
    public static void main(String[] args) {
        int num = 8;
        March13_2485 obj = new March13_2485();
        System.out.println(obj.pivotInteger(num));
    }


    public int pivotInteger(int n) {
        int y = n*(n+1)/2;
        int x = (int)Math.sqrt(y);
        if(x*x==y) return x;
        else return -1;
    }


//    public int pivotInteger(int n) {
//        if (n == 1) return 1;
//
//        int totalSum = calculateSum(n);
//
//        for (int pivot = n / 2; pivot < n; pivot++) {
//            int sumUntilPivot = calculateSum(pivot);
//            if (totalSum + pivot - sumUntilPivot == sumUntilPivot) {
//                return pivot;
//            }
//        }
//        return -1;
//    }
//
//    int calculateSum(int n) {
//        return (n * (n + 1)) / 2;
//    }
}
