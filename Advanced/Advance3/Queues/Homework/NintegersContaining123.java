package Queues.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NintegersContaining123 {
    public static void main(String[] args) {
        NintegersContaining123 obj = new NintegersContaining123();
        int A = 1;
        System.out.println(obj.solve(A));
    }

    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1); q.add(2); q.add(3);

        if(A<=3){
            for (int i=0; i<A; i++){
                ans.add(q.remove());
            }
            return ans;
        }

        ans.add(1);
        ans.add(2);
        ans.add(3);

        int count = 3;
        int newElem=0;
        while(count<A){
            int temp = q.remove();
            newElem = temp*10+1;
            q.add(newElem);
            ans.add(newElem);
            count++;

            if(count!=A){
                newElem = temp*10+2;
                q.add(newElem);
                ans.add(newElem);
                count++;
            }

            if(count!=A){
                newElem = temp*10+3;
                q.add(newElem);
                ans.add(newElem);
                count++;
            }
        }
        return ans;
    }
}
