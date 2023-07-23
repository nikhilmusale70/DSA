package BinarySearch1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {0,1,2,3,4,5,6,7,8,9};
        int k = 7;
        BinarySearch obj = new BinarySearch();
        System.out.println(obj.returnIndexBS(A,k));
    }

    int returnIndexBS(int[] A, int k){
        int left=0, right=A.length-1;
        int mid=-1;
        while (left<=right){
            mid = (left+right)/2;
            if (A[mid]==k){
                return mid;
            }
            else if(A[mid]>k){
                right=mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return mid;
    }
}
