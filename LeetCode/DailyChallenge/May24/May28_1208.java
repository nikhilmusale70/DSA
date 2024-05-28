package DailyChallenge.May24;

import java.util.Arrays;

public class May28_1208 {
    public static void main(String[] args) {
        String s = "iktqzyazth", t = "havakbjzzc";
        int maxCost = 78;
        May28_1208 obj = new May28_1208();
        System.out.println(obj.equalSubstring(s, t, maxCost));
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int[] count = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            count[i]= Math.abs(s.charAt(i)-t.charAt(i));
        }

        int ans=0;
        int temp = 0;
        int right = 0, left = 0;

        while(right<count.length){
            while(temp>maxCost){
                temp -= count[left];
                left++;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }

        return ans;
    }
}
