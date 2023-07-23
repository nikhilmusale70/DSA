package adv12Utils;

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
    public static void printNormalBooleanArray(boolean[] A){
        for (int i=0; i<A.length; i++){
            System.out.print(A[i] + " ,");
        }
        System.out.println();
    }
    public static void printNormalLongArray(long[] A){
        for (int i=0; i<A.length; i++){
            System.out.print(A[i] + " ,");
        }
        System.out.println();
    }
    public static void printNormalArray(int[] A){
        for (int i=0; i<A.length; i++){
            System.out.print(A[i] + " ,");
        }
        System.out.println();
    }

    public static ArrayList<ArrayList<Integer>> arrTo2dArrayList(int[][] A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i=0; i<A.length; i++){
            ans.add(new ArrayList<>());
            for (int j=0; j<A[i].length; j++){
                ans.get(i).add(A[i][j]);
            }
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> construct2dPrefixMatrix(ArrayList<ArrayList<Integer>> A){
        //add on col
        for(int i=0; i<A.size(); i++){
            int elem = 0;
            for(int j=0; j<A.get(0).size(); j++){
                elem = elem+A.get(i).get(j);
                A.get(i).set(j, elem);
            }
        }
        //add on col
        for(int i=0; i<A.get(0).size(); i++){
            int elem = 0;
            for(int j=0; j<A.size(); j++){
                elem = elem+A.get(j).get(i);
                A.get(j).set(i, elem);
            }
        }

        return A;
    }

    public static void print2dArray(int[][] A){
        for(int i=0; i<A.length; i++){
            System.out.println();
            for(int j=0; j<A[i].length; j++){
                System.out.print(A[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void print2dArrayLong(long[][] A){
        for(int i=0; i<A.length; i++){
            System.out.println();
            for(int j=0; j<A[i].length; j++){
                System.out.print(A[i][j] + " ");
            }
        }
        System.out.println();
    }
}
