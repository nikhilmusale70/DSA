package DailyChallenge.Dec23;

import java.util.HashSet;

public class Dec23_1496 {
    public static void main(String[] args) {
        Dec23_1496 obj = new Dec23_1496();
        System.out.println(obj.isPathCrossing("NESW"));
    }
    public boolean isPathCrossing(String path) {
        HashSet<String> hs = new HashSet<>();
        int x=0, y=0;
        hs.add("0,0");

        for(char ch: path.toCharArray()){
            if(ch=='N') y++;
            else if(ch=='S') y--;
            else if(ch=='E') x++;
            else x--;

            String cord = x+","+y;
            if (hs.contains(cord)){
                return true;
            }
            hs.add(cord);
        }
        return false;
    }
}
