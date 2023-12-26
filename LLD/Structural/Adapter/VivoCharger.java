package Structural.Adapter;

public class VivoCharger implements AndroidCharger{
    @Override
    public void chargePhone() {
        System.out.println("Charging from VIVO phone");
    }
}
