package Creational.Factory;

public class Button {
    private int size;
    private String type;

    public Button(int size, String type) {
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
}
