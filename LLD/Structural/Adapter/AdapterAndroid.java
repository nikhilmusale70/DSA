package Structural.Adapter;

public class AdapterAndroid implements AppleCharger{
    private AndroidCharger androidCharger;

    public AdapterAndroid(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargeIphone() {
        androidCharger.chargePhone();
    }
}
