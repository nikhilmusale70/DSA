package Heaps.Homework;

import adv12Utils.ScaUtils;

import java.util.*;

public class BClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] A = {
                {1,3},{-2,2}
        };
        int B = 1;
        BClosestPointsToOrigin obj = new BClosestPointsToOrigin();
        ArrayList<ArrayList<Integer>> arr = ScaUtils.arrTo2dArrayList(A);

        System.out.println(obj.solve(arr, B));
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(1, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int distanceOne = (int) (Math.pow(o1.get(0), 2) + Math.pow(o1.get(1), 2));
                int distanceTwo = (int) (Math.pow(o2.get(0), 2) + Math.pow(o2.get(1), 2));
                return distanceOne-distanceTwo;
            }
        });

        pq.addAll(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i=0; i<B; i++){
            ans.add(pq.remove());
        }

        return ans;
    }
}
