package BinarySearch1.Homework;

public class MatrixSearch {
    public static void main(String[] args) {
        MatrixSearch obj = new MatrixSearch();
        int[][] A = {
                {2,   3,  4,  6},
                {16, 19, 33, 36},
                {37, 38, 38, 41},
                {47, 47, 50, 51},
                {55, 57, 58, 62},
                {63, 65, 66, 66},
                {68, 70, 75, 77},
                {78, 84, 84, 86},
                {86, 87, 88, 92},
                {94, 95, 96, 97}
        };
        int B = 81;
        System.out.println(obj.searchMatrix(A,B));
    }

    public int searchMatrix(int[][] A, int B) {
         //lets find the row for our element
        int row = -1;
        for (int i=0; i<A.length; i++){
            if (A[i][0]<=B && A[i][A[i].length-1]>=B){
                row=i;
            }
        }
        System.out.println(row);
        if (row==-1)
            return 0;

        //lets binary search on row
        int l=0, r=A[row].length-1;
        int mid=-1;
        while (l<=r){
            mid = (l+r)/2;
            if (A[row][mid]==B)
                return 1;
            if(A[row][mid]>B)
                r=mid-1;
            if (A[row][mid]<B)
                l=mid+1;
        }
        return 0;
    }
}
