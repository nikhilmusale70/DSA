package AdvanceDsa_Arrays1.HomeWork;

import adv12Utils.ScaUtils;

import java.util.ArrayList;

public class Add1 {
    public static void main(String[] args) {
//        int[] A = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
        int[] A = { 1, 9, 9, 9, 9, 9, 9 };

        ArrayList<Integer> arrlis = ScaUtils.arrToArrayList(A);
        System.out.println(plusOne(arrlis));
    }

//    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
//        long noOfZeroOnStart = 0;
//
//        for(int i=0; i<A.size(); i++){
//            if(A.get(i)==0) noOfZeroOnStart++;
//            else{
//                break;
//            }
//        }
//
//        if(A.size() == noOfZeroOnStart) {
//            ArrayList<Integer> allZero = new ArrayList<>();
//            allZero.add(1);
//            return allZero;
//        }
//
//        long number=A.get((int)noOfZeroOnStart);
//        for(long i=noOfZeroOnStart; i<A.size()-1; i++){
//            number = number*10 + A.get((int)i+1);
//        }
//        System.out.println(number);
//        number++;
//
//        return numberIntoArray(number);
//    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int noOfZeroOnStart = 0;
        ArrayList<Integer> ansList = new ArrayList<>();


        for(int i=0; i<A.size(); i++){
            if(A.get(i)==0) noOfZeroOnStart++;
            else{
                break;
            }
        }
        if(A.size() == noOfZeroOnStart) {
            ansList.add(1);
            return ansList;
        }

        int carry=0;
        int elem;
        for(int i=A.size()-1; i>=noOfZeroOnStart; i--){
            if(i==A.size()-1) {
                elem = A.get(i)+1;
                if(elem==10){
                    carry=1;
                    ansList.add(0, 0);
                }
                else{
                    ansList.add(0, elem+carry);
                }
            }
            else {
                elem = A.get(i)+carry;
                System.out.println("For i: "+i+ " elem: "+elem);
                if(elem==10){
                    carry=1;
                    ansList.add(0, 0);
                }
                else{
                    ansList.add(0, elem);
                    carry=0;
                }

            }
        }
        if(carry==1){
            ansList.add(0,1);
        }
        return ansList;
    }

//    public static ArrayList<Integer> numberIntoArray(long number){
//        long tempNum;
//        ArrayList<Integer> ans = new ArrayList<>();
//        while(number>0){
//            tempNum = number%10;
//            number /= 10;
//            ans.add(0, (int)tempNum);
//        }
//        return ans;
//    }
}
