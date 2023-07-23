package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public static void main(String[] args) {
        PerfectNumbers obj = new PerfectNumbers();
        int A = 4;
        System.out.println(obj.solve(A));
    }

    public String solve(int A) {
        StringBuilder specialNumber = new StringBuilder(nSpecialNumber(A));
        String original = specialNumber.toString();
        String rev = specialNumber.reverse().toString();
        return original+rev;
    }

    public String nSpecialNumber(int n){
        if(n<=2){
            return n+"";
        }
        Queue<String> q = new LinkedList<>();
        q.add("1"); q.add("2");
        int curr = 2;
        while(curr<n){
            String temp = q.peek();
            q.remove();

            q.add(temp+"1");
            curr++;
            if(curr == n){
                return temp+"1";
            }
            q.add(temp+"2");
            curr++;
            if(curr==n){
                return temp+"2";
            }
        }
        return "hello";
    }
}
