package Structural.Decorator;

public class PannerTopping extends PizzaDecorator{
    BasePizza currentPizz;
    public PannerTopping(BasePizza currentPizz){
        this.currentPizz = currentPizz;
    }
    @Override
    public int cost() {
        return currentPizz.cost() + 50;
    }
}
