package DailyChallenge.Feb24;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Feb7_451 {
    public static void main(String[] args) {
        String str= "tree";
        Feb7_451 obj = new Feb7_451();
        System.out.println(obj.frequencySort(str));
    }
    class Pair{
        char val1;
        int val2;
        Pair(char x, int y){
            this.val1 = x;
            this.val2 = y;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch: s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2)-> p2.val2-p1.val2);
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character, Integer> e: hm.entrySet()){
            maxHeap.add(new Pair(e.getKey(), e.getValue()));
        }

        while(!maxHeap.isEmpty()){
            Pair curr = maxHeap.remove();
            for(int i=0; i<curr.val2; i++){
                sb.append(curr.val1);
            }
        }
        return sb.toString();
    }
}
