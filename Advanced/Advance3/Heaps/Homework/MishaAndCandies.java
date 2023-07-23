package Heaps.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MishaAndCandies {
    public static void main(String[] args) {
        int[] A = {9,818,174,237,892,109,522,27,59,336,605,865,714,86,708,535,138,948,836,287,179,754,466,856,153,53,958,951,262,341,769,491,772,509,336,120,98,805,169,984,520,447,256,266,348,351,60,563,45,638,29,479,400};
        int B = 852;
        MishaAndCandies obj = new MishaAndCandies();
        System.out.println(obj.solve(A, B));
        System.out.println(6901);
    }
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //min heap
        for (int i=0; i<A.length; i++){
            if(A[i]<B)
                pq.add(A[i]);
        }
        //now misha will eat the chocolate and will add the remaining
        //misha will not eat choco above B in a box
        int ans=0;
        while(pq.size()>0 && pq.peek()<=B){
            int chocoInBox = pq.remove();
            int chocoMishaEats = chocoInBox/2;
            int chocoToAdd = chocoInBox-chocoMishaEats;

            ans += chocoMishaEats;

            if(pq.isEmpty())break;
            pq.add(pq.remove()+chocoToAdd);

        }
        System.out.println(pq.peek());
        return ans;
    }
}
