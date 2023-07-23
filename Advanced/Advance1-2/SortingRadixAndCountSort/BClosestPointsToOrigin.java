package SortingRadixAndCountSort;

import adv12Utils.ScaUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BClosestPointsToOrigin {
    public static void main(String[] args) {
        BClosestPointsToOrigin obj = new BClosestPointsToOrigin();
        int[][] A = { {26,41}, {40,47}, {47,7}, {50,34}, {18,28} };
        obj.solve(ScaUtils.arrTo2dArrayList(A), 5);
    }
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList <ArrayList <Integer>> ans = new ArrayList <ArrayList <Integer>>();
        // sorts the list based on euclidean distance from origin
        Collections.sort(A, new Comparator<ArrayList <Integer>>() {
            public int compare(ArrayList <Integer> a, ArrayList <Integer> b) {
                long d1 = (long)a.get(0) * a.get(0) + (long)a.get(1) * a.get(1);
                long d2 = (long)b.get(0) * b.get(0) + (long)b.get(1) * b.get(1);
                if(d1 < d2)return -1;
                else if(d2 < d1)return 1;
                else return 0;
            }
        });
        for(int i = 0; i < B; i++){
            ans.add(A.get(i));
        }
        return ans;
    }


}
