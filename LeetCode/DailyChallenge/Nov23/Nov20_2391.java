package DailyChallenge.Nov23;

public class Nov20_2391 {
    public static void main(String[] args) {
        Nov20_2391 obj = new Nov20_2391();
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        System.out.println(obj.garbageCollection(garbage, travel));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int[] houseNum = new int[3];

        int[] time = new int[garbage.length];
        time[0] = 0;
        int ans = 0;

        for(int house=0; house<garbage.length; house++){
            if(house>0){
                time[house] = travel[house-1] + time[house-1];
            }
            ans += garbage[house].length();

            if(garbage[house].contains("M")){
                houseNum[0]=house;
            }
            if (garbage[house].contains("P")) {
                houseNum[1]=house;
            }
            if(garbage[house].contains("G")) {
                houseNum[2] = house;
            }
        }
        for (int j : houseNum) {
            ans += time[j];
        }
        return ans;
    }
}
