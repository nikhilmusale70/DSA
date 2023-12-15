package DailyChallenge.Dec23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Dec15_1436 {
    public static void main(String[] args) {
        Dec15_1436 obj = new Dec15_1436();
        List<List<String>> cityConnections = new ArrayList<>();

        // Adding connections to the list
        cityConnections.add(List.of("London", "New York"));
        cityConnections.add(List.of("New York", "Lima"));
        cityConnections.add(List.of("Lima", "Sao Paulo"));
        System.out.println(obj.destCity(cityConnections));
    }

    public String destCity(List<List<String>> paths) {
        String destination = null;
        HashSet<String> hs = new HashSet<>();
        for(List<String> path : paths){
            hs.add(path.get(0));
            if(!hs.contains(path.get(1))){
                destination = path.get(1);
                break;
            }
        }
        return destination;
    }
}
