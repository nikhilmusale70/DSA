package BinarySearch1.Homework;

public class MatrixMedian {
    public static void main(String[] args) {
        MatrixMedian obj = new MatrixMedian();
        int[][] A = {   {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}   };
        System.out.println(obj.findMedian(A));
    }

    public int findMedian(int[][] A) {
        int ans=0;
        int lo=0; int hi=Integer.MAX_VALUE;
        int n=A.length, m=A[0].length;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            int count =0;

            for (int i=0; i<n; i++)
                count += count(A[i], mid);

            if (count==(n*m)/2)
                ans = mid;
            if(count<=(n*m)/2){
                ans = mid;
                lo = mid+1;
            }
            else
                hi = mid-1;
        }
        return ans;
    }

    public int count(int[]A, int val){
        int l=0, r=A.length-1;
        int mid,len = 0;
        while (l<=r){
            mid = l + (r-l)/2;
            if (A[mid]<val) {
                len = mid+1;
                l=mid+1;
            }
            else r=mid-1;
        }
        return len;
    }
}
