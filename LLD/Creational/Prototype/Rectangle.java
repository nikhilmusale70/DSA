package Creational.Prototype;

public class Rectangle implements ObjectClonable{

    private int length;
    private int breath;
    private String color;

    public Rectangle(int length, int breath, String color) {
        this.length = length;
        this.breath = breath;
        this.color = color;
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(length, breath, color);
    }
}
