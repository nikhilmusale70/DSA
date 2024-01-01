package DailyChallenge.Jan24;

import java.util.Arrays;

public class Jan1 {
    public static void main(String[] args) {
        Jan1 obj = new Jan1();
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(obj.findContentChildren(g,s));
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int currChild = 0;
        for(int i=0; i<s.length && currChild<g.length; i++){
            if(g[currChild]<=s[i]){
                currChild++;
            }
        }
        return currChild;
    }
}
