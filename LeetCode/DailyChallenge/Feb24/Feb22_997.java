package DailyChallenge.Feb24;

public class Feb22_997 {
    public static void main(String[] args) {
        Feb22_997 obj = new Feb22_997();
        int n = 3;
        int[][] trust = {{1,3},{2,3},{3,1}};
        System.out.println(obj.findJudge(n, trust));
    }
    public int findJudge(int n, int[][] trust) {
        int[] trustCounts = new int[n+1]; // Array to track net trust count for each person

        // Calculate net trust count for each person
        for(int[] trustRelation: trust){
            int trustor = trustRelation[0]; // The person who trusts
            int trustee = trustRelation[1]; // The person being trusted

            // Decrement trust count for the trustor and increment for the trustee
            trustCounts[trustor]--;
            trustCounts[trustee]++;
        }

        // Check for the person with net trust count of n-1 (the judge)
        for(int person = 1; person <= n; person++){
            if(trustCounts[person] == n-1){
                return person; // Found the judge
            }
        }
        return -1; // No judge found
    }

}
