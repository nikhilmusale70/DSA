package Structural.Decorator;

public class Runner {
    public static void main(String[] args) {
        BasePizza pizza = new SixInch();
        System.out.println(pizza.cost());

        pizza = new PannerTopping(pizza);
        System.out.println(pizza.cost());

        pizza = new CheeseTopping(pizza);
        System.out.println(pizza.cost());
    }
}
