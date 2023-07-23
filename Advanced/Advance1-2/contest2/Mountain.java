package contest2;

public class Mountain {
    public static void main(String[] args) {
        int[] A = {3,4,4,6,6,3,3,1};
        Mountain obj = new Mountain();
        System.out.println(obj.solve(A));
    }

    public int solve(int [] A){
        //create 2 pointers till they cross each other
        int l=0; int r=A.length-1;
        int ans=0;
        while (l<r){
            //move l till it gets blocked
            while (l<r && A[l]<A[l+1]){
                l++;
            }
            while (l<r && A[r-1]>A[r]){
                r--;
            }
            if(l==r)
                break;

            if(A[l]<A[r]){
                ans += A[l]-A[l+1]+1;
                A[l+1]=A[l]+1;
            }
            else{
                ans += A[r]-A[r-1]+1;
                A[r-1]=A[r]+1;
            }
        }
        return ans;
    }
}
