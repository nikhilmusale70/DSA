package Structural.Decorator;

public class CheeseTopping extends PizzaDecorator{
    BasePizza currentPizz;
    public CheeseTopping(BasePizza currentPizz){
        this.currentPizz = currentPizz;
    }
    @Override
    public int cost() {
        return currentPizz.cost()+20;
    }
}
