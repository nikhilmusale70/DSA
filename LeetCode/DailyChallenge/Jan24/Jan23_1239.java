package DailyChallenge.Jan24;

import java.util.List;

public class Jan23_1239 {
    public static void main(String[] args) {
        String one= "aa";
        String two= "bb";
        Jan23_1239 obj = new Jan23_1239();
        System.out.println(obj.maxLength(List.of(one, two)));
    }
    public int maxLength(List<String> arr) {
        return helper(arr, arr.size()-1, "");
    }

    int helper(List<String> arr, int idx, String ans){
        if(idx==-1) return ans.length();

        int pick = 0;
        if(checkIfCanMerge(ans, arr.get(idx))){
            pick = helper(arr, idx-1, ans + arr.get(idx));
        }
        int dontPick = helper(arr, idx-1, ans);

        return Math.max(pick, dontPick);
    }

    boolean checkIfCanMerge(String one, String two){
        int[] freqArr= new int[26];
        for(char ch: one.toCharArray()){
            if(freqArr[ch-'a']==1){
                return false;
            }
            freqArr[ch-'a']++;
        }
        for(char ch: two.toCharArray()){
            if(freqArr[ch-'a']==1 || freqArr[ch-'a']==-1){
                return false;
            }
            freqArr[ch-'a']--;
        }
        return true;
    }
}
