package DailyChallenge.May24;

import java.util.Arrays;

public class May4_881 {
    public static void main(String[] args) {
        int[] people = {3,5,3,4};
        int limit = 5;
        May4_881 obj = new May4_881();
        System.out.println(obj.numRescueBoats(people, limit));
    }
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int numberOfBoatsRequired = 0;

        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
            }
            right--;
            numberOfBoatsRequired++;
        }
        return numberOfBoatsRequired;
    }
}
