package Structural.Adapter;

public class Runner {
    public static void main(String[] args) {
        AndroidCharger androidCharger = new VivoCharger();
        AppleCharger charger = new AdapterAndroid(androidCharger);

        Iphone12 phone = new Iphone12(charger);
        phone.chargePhone();
    }
}
