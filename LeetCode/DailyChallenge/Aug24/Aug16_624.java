package DailyChallenge.Aug24;

import java.util.Arrays;
import java.util.List;

public class Aug16_624 {

    public static void main(String[] args) {
        List<List<Integer>> arrays = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(1, 2, 3)
        );
        Aug16_624 obj = new Aug16_624();
        System.out.println(obj.maxDistance(arrays));
    }
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.getFirst().getFirst();
        int max = arrays.getFirst().getLast();
        int maxDistance = 0;

        for(int i=1; i<arrays.size(); i++){
            int tempMin = arrays.get(i).getFirst();
            int tempMax = arrays.get(i).getLast();

            maxDistance = Math.max(maxDistance, Math.abs(max - tempMin));
            maxDistance = Math.max(maxDistance, Math.abs(min - tempMax));

            min = Math.min(min, tempMin);
            max = Math.max(max, tempMax);
        }

        return maxDistance;
    }
}
