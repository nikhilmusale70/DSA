package Structural.Adapter;

public class Iphone12 {
    AppleCharger charger;

    public Iphone12(AppleCharger charger) {
        this.charger = charger;
    }

    public void chargePhone(){
        charger.chargeIphone();
    }
}
