package DailyChallenge.June24;

import java.util.Arrays;

public class June11_1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        June11_1122 obj = new June11_1122();
        System.out.println(Arrays.toString(obj.relativeSortArray(arr1, arr2)));

    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for(int num: arr1){
            freq[num]++;
        }
        int i=0;
        for(int num: arr2){
            while(freq[num]>0){
                arr1[i]=num;
                freq[num]--;
                i++;
            }
        }
        for(int j=0; j<freq.length; j++){
            while(freq[j]>0){
                arr1[i] = j;
                freq[j]--;
                i++;
            }
        }
        return arr1;
    }
}
