package Behavioural.Strategy;

public class AdditionStrategy implements OperationStrategy{
    @Override
    public int operate(int a, int b) {
        return a+b;
    }
}
