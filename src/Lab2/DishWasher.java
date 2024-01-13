package Lab2;

class DishWasher extends HouseHold {
    @Override
    public void soundMade() {
        System.out.println("Dr Dr Dr vvvvvv");
    }
    @Override
    public void DirectionAskedToMoveTo() {
        System.out.println("to kitchen");
    }

    private int capacity;
    private boolean wasRepaired;
    private String constructor;

    public int getCapacity() {return capacity;}
    public String getConstructor() {return constructor;}
    public boolean getWasRepaired(){return wasRepaired;}

    public void setCapacity(int capacity) {this.capacity = capacity;}

    public void setConstructor(String constructor) {this.constructor = constructor;}

    public void setWasRepaired(boolean wasRepaired) {this.wasRepaired = wasRepaired;}

    public DishWasher(String x, int y, boolean z, int a, boolean b, String c) {
        super(x, y, z);
        this.capacity = a;
        this.wasRepaired =b;
        this.constructor =c;
    }
    public DishWasher(){this("Placeholder",1,false,10,false,"Bosch");}
};
