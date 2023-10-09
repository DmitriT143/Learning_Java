public class Appliance {
    private int amountOfAppliance;
    private int getAmountOfAppliancePositions;
    public Appliance() {
        if (this.getClass() == Appliance.class){amountOfAppliance++;}
    }
}
class Fridges extends Appliance{

};
class WashingMachines extends Appliance{

};
class VacuumCleaners extends Appliance{

};