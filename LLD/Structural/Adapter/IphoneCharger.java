package Structural.Adapter;

public class IphoneCharger implements AppleCharger {
    @Override
    public void chargeIphone() {
        System.out.println("Charging from original apple chrager");
    }
}
