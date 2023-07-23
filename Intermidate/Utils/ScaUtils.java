package Utils;

import java.util.ArrayList;

public class ScaUtils {
    public static ArrayList<Integer> arrToArrayList(int[] A){
        ArrayList<Integer> tempArr = new ArrayList<>();
        for (int i=0; i<A.length; i++){
            tempArr.add(A[i]);
        }
        return tempArr;
    }

    public static ArrayList<Character> stringToCharArr(String A){
        ArrayList<Character> tempArr = new ArrayList<>();
        for (int i=0; i<A.length(); i++){
            tempArr.add(A.charAt(i));
        }
        return tempArr;
    }

    public static ArrayList<Character> arrToArrayListForChar(int[] A){
        ArrayList<Character> tempArr = new ArrayList<>();
        for (int i=0; i<A.length; i++){
            tempArr.add((char) A[i]);
        }
        return tempArr;
    }
    public static void printNormalArray(int[] A){
        for (int i=0; i<A.length; i++){
            System.out.print(A[i] + " ,");
        }
    }
}
