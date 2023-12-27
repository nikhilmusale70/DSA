package DailyChallenge.Dec23;

public class Dec27_1578 {
    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1,2,3,4,5};
        Dec27_1578 obj = new Dec27_1578();
        System.out.println(obj.minCost(colors, neededTime));
    }
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        char[] color = colors.toCharArray();

        for(int i=0; i<color.length-1; i++){
            if(color[i] == color[i+1]){
                ans += Math.min(neededTime[i], neededTime[i+1]);

                if(neededTime[i]>neededTime[i+1]){
                    neededTime[i+1] = neededTime[i];
                }
            }
        }
        return ans;
    }
}
