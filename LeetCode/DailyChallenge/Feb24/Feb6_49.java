package DailyChallenge.Feb24;

import java.util.*;

public class Feb6_49 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        Feb6_49 obj = new Feb6_49();
        System.out.println(obj.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, ArrayList<String>> hm = new HashMap<>();

        for(String str: strs){
            List<Integer> freq = freqArr(str);
            if(!hm.containsKey(freq)){
                hm.put(freq, new ArrayList<>());
            }
            ArrayList<String> ar = hm.get(freq);
            ar.add(str);

            hm.put(freq, ar);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<List<Integer>, ArrayList<String>> entry: hm.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    List<Integer> freqArr (String str){
        List<Integer> freqList = new ArrayList<>(Arrays.asList(new Integer[26]));
        Collections.fill(freqList, 0);
        for(char ch: str.toCharArray()){
            freqList.set(ch-'a', freqList.get(ch-'a')+1);
        }
        return freqList;
    }
}
