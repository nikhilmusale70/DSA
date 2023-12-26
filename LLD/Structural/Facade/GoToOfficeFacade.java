package Structural.Facade;

public class GoToOfficeFacade {
    private GetDressed getDressed;
    private Transportation transportation;
    GoToOfficeFacade(GetDressed getDressed, Transportation transportation){
        this.getDressed = getDressed;
        this.transportation = transportation;
    }

    private void getDressed(){
        getDressed.packBag();
        getDressed.wearShirt();
        getDressed.wearPant();
    }
    private void reachOffice(){
        transportation.getRickshaw();
        transportation.payRickshaw();
    }
    void goOffice(){
        getDressed();
        reachOffice();
    }
}
