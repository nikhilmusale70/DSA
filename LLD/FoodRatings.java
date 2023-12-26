import java.util.*;

public class FoodRatings {
    static class Pair{
        String food;
        int newRating;
        Pair(String food, int newRating){
            this.food = food;
            this.newRating = newRating;
        }
    }

    Map<String, PriorityQueue<Pair>> cuisineFoodMap;
    Map<String, String> foodCuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFoodMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();

        for(int i=0; i<foods.length; i++){
            foodCuisineMap.put(foods[i], cuisines[i]);

            Pair p = new Pair(foods[i], ratings[i]);
            if(!cuisineFoodMap.containsKey(cuisines[i])){
                cuisineFoodMap.put(cuisines[i], new PriorityQueue(new Comparator<Pair>(){
                    @Override
                    public int compare(Pair p1, Pair p2){
                        int result = p1.newRating - p2.newRating;
                        if(result==0){
                            return (p1.food).compareTo(p2.food);
                        }
                        return result;
                    }
                }));
            }
            cuisineFoodMap.get(cuisines[i]).add(p);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        cuisineFoodMap.get(cuisine).removeIf(pair -> pair.food.equals(food));
        cuisineFoodMap.get(cuisine).add(new Pair(food, newRating));
    }

    public String highestRated(String cuisine) {
        if (cuisineFoodMap.containsKey(cuisine) && !cuisineFoodMap.get(cuisine).isEmpty()) {
            return Objects.requireNonNull(cuisineFoodMap.get(cuisine).peek()).food;
        }
        return null;
    }
}