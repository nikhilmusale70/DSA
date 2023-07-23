package LL2SortingAndDetectingLoop;

import adv12Utils.ScaUtils;

import java.util.ArrayList;

public class PreRead1SortedArr {
    public static void main(String[] args) {
        int[] A = {-4, 3};
        int[] B = {-2,-2};

        PreRead1SortedArr obj = new PreRead1SortedArr();
        System.out.println(obj.solve(ScaUtils.arrToArrayList(A), ScaUtils.arrToArrayList(B)));
    }



    public ArrayList<Integer> solve(final ArrayList<Integer> A, final ArrayList<Integer> B) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        //create 2 pointers to keep a trach
        int p1 = 0;
        int p2 = 0;
        //p1 for list1 and p2 for list 2

        int l1= A.size(), l2=B.size();
        int i=0;

        System.out.println(A);
        System.out.println(B);

        while(i<l1+l2){
            if(p1>=l1){
                arr.add(B.get(p2));
                p2++;
            }
            else if(p2>=l2){
                arr.add(A.get(p1));
                p1++;
            }
            else{
                if(A.get(p1)>B.get(p2)){
                    arr.add(B.get(p2));
                    p2++;
                }
                else{
                    arr.add(A.get(p1));
                    p1++;
                }
            }
            i++;
        }
        return arr;
    }
}
