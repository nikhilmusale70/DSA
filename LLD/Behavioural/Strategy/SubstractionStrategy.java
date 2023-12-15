package Behavioural.Strategy;

public class SubstractionStrategy implements OperationStrategy{
    @Override
    public int operate(int a, int b) {
        return a-b;
    }
}
