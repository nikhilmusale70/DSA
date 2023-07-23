package LL2SortingAndDetectingLoop;

import java.util.ArrayList;

public class PreRead2MergeSort {
//    public static void main(String[] args) {
//        int[] A = {1, 4, 10, 2, 1, 5};
//        PreRead2MergeSort obj = new PreRead2MergeSort();
//        ScaUtils.printNormalArray(obj.solve(A));
//    }
//
//    public int[] solve(int[] A) {
//        int leftIndex = 0;
//        int rightIndex = A.length-1;
//
//        int mid=(leftIndex + rightIndex)/2;
//    }

    public ArrayList<Integer> merge(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr){
        ArrayList<Integer> arr = new ArrayList<Integer>();

        //create 2 pointers to keep a trach
        int p1 = 0;
        int p2 = 0;
        //p1 for list1 and p2 for list 2

        int l1= leftArr.size(), l2=rightArr.size();
        int i=0;

        System.out.println(leftArr);
        System.out.println(rightArr);

        while(i<l1+l2){
            if(p1>=l1){
                arr.add(rightArr.get(p2));
                p2++;
            }
            else if(p2>=l2){
                arr.add(leftArr.get(p1));
                p1++;
            }
            else{
                if(leftArr.get(p1)>rightArr.get(p2)){
                    arr.add(rightArr.get(p2));
                    p2++;
                }
                else{
                    arr.add(leftArr.get(p1));
                    p1++;
                }
            }
            i++;
        }
        return arr;
    }
}
