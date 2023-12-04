package Creational.Factory;

public class RoundButton extends ButtonFactory{
    @Override
    public Button createButton() {
        return new Button(2, "round");
    }
}
