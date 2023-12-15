package Behavioural.Strategy;

public class Runner {
    public static void main(String[] args) {
        OperationStrategy operationStrategy = new AdditionStrategy();
        System.out.println(operationStrategy.operate(1,2));
    }
}
