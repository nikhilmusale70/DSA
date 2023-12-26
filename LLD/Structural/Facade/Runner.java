package Structural.Facade;

public class Runner {
    public static void main(String[] args) {
        GoToOfficeFacade goToOfficeFacade = new GoToOfficeFacade(new GetDressed(), new Transportation());
        goToOfficeFacade.goOffice();
    }
}
