public abstract class HouseHold {
    public abstract void soundMade();
    public abstract void DirectionAskedToMoveTo();
    static int positions;
    public int getPositions(){return positions;}
    private String name;
    private int amount;
    private boolean onSale;
    public HouseHold(String x, int y, boolean z){
        name = x; amount = y; onSale = z;
        positions++;
    }
    public String getName(){ return name;}
    public int getAmount(){ return amount;}
    public boolean getOnSale(){ return onSale;}
    public  void setName(String val){this.name = val;}
    public  void setAmount (int val){this.amount = val;}
    public  void setOnSale (boolean val){this.onSale = val;}
}


class Fridge extends HouseHold{
    @Override
    public void DirectionAskedToMoveTo(){System.out.println("to bar");}
    @Override
    public void soundMade(){System.out.println("Minsk Noises");}
    private int temp;
    private boolean wasRepaired;
    static int FridgeModelsAmount;
    public void setTemp (int val){this.temp = val;}
    public void setWasRepaired (boolean val){this.wasRepaired = val;}
    public void setFridgeModelsAmount(int val){FridgeModelsAmount = val;}
    public int getTemp(){return  this.temp;}
    public int getFridgeModelsAmount(){return FridgeModelsAmount;}
    public boolean getWasRepaired(){return wasRepaired;}
    public Fridge (String x, int y, boolean z, int a, boolean b){
        super(x,y,z);
        this.temp = a;
        this.wasRepaired = b;
        if(this.getClass() == Fridge.class){
            setFridgeModelsAmount(getFridgeModelsAmount()+1);}
    }
    public Fridge(){this("Placeholder",1,false,-5,false);}

    public static void main(String[] args){
        DishWasher Rita = new DishWasher("Hard West",10,true,50,false,"Bosch");
        DishWasher Magda = new DishWasher();
        DishWasher Senna = new DishWasher();
        Rita.soundMade();
        System.out.println("We have made "+ Rita.getPositions() + " positions on our list only of Dishwashers, but we can't find only dishwashers after that");
        Fridge Belarus = new Fridge("Old Blue",5,true,-5,true);
        Fridge Roman = new Fridge("New Red", 15,true, -10, false);
        MinscFridge Minsk1092 = new MinscFridge("Minsk Old",1,false,-1,false,"1092");
        vacuumCleaner ProVac = new vacuumCleaner();
        vacuumCleaner AntiVac = new vacuumCleaner();
        AntiVac.setAmount(25);
        AntiVac.setName("AntiVac");
        AntiVac.soundMade();
        System.out.println("We have "+ Belarus.getFridgeModelsAmount() + " Fridge models as we made extra counter for them");
        System.out.println("We have " + ProVac.getPositions() + " Positions now and 1 of them is taken by " + AntiVac.getAmount() + " of " + AntiVac.getName());
        Belarus.soundMade();
        System.out.println("Our "+ Belarus.getName() +" Fridges from " + Belarus.getClass() + " get to " + Belarus.temp + " degrees");
        Minsk1092.soundMade();
        System.out.println("Also we can make an Extend of an Extend, e.g. Household -> Fridge -> MinskFridge with it's own construct and extra fields, like extra model " + Minsk1092.getMinskModel());
    }
}
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
class MinscFridge extends Fridge{
    private String minskModel;

    public String getMinskModel() {
        return minskModel;
    }
    public void setMinskModel(String minskModel) {
        this.minskModel = minskModel;
    }
    @Override
    public void soundMade(){System.out.println("True minsk sound");}
    public MinscFridge(String x,int y,boolean z, int a, boolean b, String mod){
        super(x,y,z,a,b);
        this.minskModel = mod;
    }
}
class vacuumCleaner extends HouseHold {
    @Override
    public void soundMade() {System.out.println("Vrrrrrrrr");}
    @Override
    public void DirectionAskedToMoveTo() {System.out.println("Take me anywhere dirty enough");}
    private int warrantyPeriod;
    private String[] modesOfCleaning;
    private boolean wasUsed;

    public int getWarrantyPeriod() {return warrantyPeriod;}
    public String[] getModesOfCleaning() {return modesOfCleaning;}
    public boolean getWasUsed() {return wasUsed;}
    public void setWarrantyPeriod(int val){warrantyPeriod = val;}
    public void setModesOfCleaning(String[] val){modesOfCleaning = val;}
    public void setWasUsed(boolean val){wasUsed = val;}
    public vacuumCleaner(String x, int y, boolean z, int a, boolean b, String[] c) {
        super(x, y, z);
        warrantyPeriod = a;
        wasUsed = b;
        modesOfCleaning = c;
    }
    public vacuumCleaner(){this("Placeholder",1,false,31,true,new String[]{"Normal","Fast"});}
};