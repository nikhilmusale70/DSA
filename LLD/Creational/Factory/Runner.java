package Creational.Factory;

public class Runner {
    public static void main(String[] args) {
        RectangleButton rect = new RectangleButton();
        Button button = rect.createButton();
        System.out.println(button.getType());
    }
}
