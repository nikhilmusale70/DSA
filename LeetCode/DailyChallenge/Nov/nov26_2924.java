package DailyChallenge.Nov;

import java.util.HashSet;
import java.util.Set;

public class nov26_2924 {
    public static void main(String[] args) {
        nov26_2924 obj = new nov26_2924();
        int n = 3;
        int[][] edges = {{0,1}};
        System.out.println(obj.findChampion(n, edges));
    }
    public int findChampion(int n, int[][] edges) {
        int[] teams = new int[n];
        for(int[] edge: edges){
            teams[edge[1]]++;
        }
        int ans = -1;
        for(int i=0; i<n; i++){
            if(teams[i]==0 && ans!=-1){
                return -1;
            }
            else if(teams[i]==0){
                ans = i;
            }
        }
        return ans;
    }
}
