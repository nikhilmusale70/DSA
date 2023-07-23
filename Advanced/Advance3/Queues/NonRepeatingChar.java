package Queues;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String  A = "abadbc"; // aabbdd
        NonRepeatingChar obj = new NonRepeatingChar();
        System.out.println(obj.solve(A));
    }

    public String solve(String A) {
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i=0; i<A.length(); i++){
            char curr = A.charAt(i);
            q.add(curr);
            hm.put(curr, hm.getOrDefault(curr, 0)+1);

            while(!q.isEmpty() && hm.get(q.peek())!=1){
                q.remove();
            }
            if(q.isEmpty()){
                ans.append("#");
            }
            else {
                ans.append(q.peek());
            }
        }
        return ans.toString();
    }
}
