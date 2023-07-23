package Sorting_Merge_Selection;

public class InversionCountInArray {
    public static void main(String[] args) {
        int[] A = {45, 10, 15, 25, 50 };
        InversionCountInArray obj = new InversionCountInArray();
        System.out.println(obj.solve(A));
    }

    public int solve(int[] A) {
        long[] count ={0};
        sort(A, 0, A.length-1, count);
        int mod = 1000000007;
        return (int) (count[0]%mod);
    }
    void sort(int[] A, int start, int end, long[] count){
        if(start<end){
            int mid = (start+end)/2;

            sort(A, start, mid, count);
            sort(A, mid+1, end, count);

            merge(A, start, mid, end, count);
        }
    }

    void merge(int[] arr, int start, int mid, int end, long[] count){
        long mod= 1000000007;
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i=0; i<n1; i++){
            leftArr[i] = arr[start+i];
        }
        for (int i=0; i<n2; i++){
            rightArr[i] = arr[mid+1+i];
        }

        int leftIndex =0; int rightIndex =0;
        int k = start;
        while (leftIndex<leftArr.length && rightIndex<rightArr.length){
            if(leftArr[leftIndex]>rightArr[rightIndex]){
                arr[k] = rightArr[rightIndex];
                rightIndex++;
                k++;
                count[0] += ((leftArr.length - leftIndex)%mod);
            }
            else {
                arr[k] = leftArr[leftIndex];
                leftIndex++;
                k++;
            }
        }

        while (leftIndex<leftArr.length){
            arr[k] = leftArr[leftIndex];
            leftIndex++;
            k++;
        }
        while(rightIndex<rightArr.length){
            arr[k] = rightArr[rightIndex];
            rightIndex++;
            k++;
        }
    }
}
