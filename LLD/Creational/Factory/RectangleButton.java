package Creational.Factory;


public class RectangleButton extends ButtonFactory{

    @Override
    public Button createButton() {
        return new Button(1, "rectangle");
    }
}
