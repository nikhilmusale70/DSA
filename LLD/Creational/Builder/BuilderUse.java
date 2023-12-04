package Creational.Builder;

public class BuilderUse {
    public static void main(String[] args) {
        Builder obj = Builder
                .builder()
                .setCar("honda")
                .setCarColor("Green")
                .build();
    }
}
