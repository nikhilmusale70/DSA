package AdvanceHashing1.Homework;

import adv12Utils.ScaUtils;

import java.util.*;

public class SortArrayInGivenOrder {
    public static void main(String[] args) {
        int[]A={10, 2, 18, 16, 16, 16};
        int[]B={3, 13, 2, 16, 4, 19};

        /*
        6 14  15 5 10
        * */
        SortArrayInGivenOrder obj = new SortArrayInGivenOrder();
        System.out.println(obj.solve(ScaUtils.arrToArrayList(A),ScaUtils.arrToArrayList(B)));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer integer : A) {
            hm.put(integer, hm.getOrDefault(integer, 0) + 1);
        }

        System.out.println(hm);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<B.size(); i++){
            if (hm.containsKey(B.get(i))){
                while (hm.get(B.get(i))>0) {
                    ans.add(B.get(i));
                    hm.put(B.get(i), hm.get(B.get(i))-1);
                }
                hm.remove(B.get(i));
            }
        }

        if (ans.size()<A.size()) {
            for (int i = 0; i < A.size(); i++) {
                if (hm.containsKey(A.get(i))) {
                    while(hm.get(A.get(i))>0) {
                        ans.add(A.get(i));
                        hm.put(A.get(i), hm.get(A.get(i))-1);
                    }
                }
            }
        }

        return ans;
    }
}
