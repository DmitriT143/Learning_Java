package Lab2;

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


    public static void main(String[] args){
        Fridge Dno = new Fridge();
        DishWasher Rita = new DishWasher("Hard West",10,true,50,false,"Bosch");
        DishWasher Magda = new DishWasher();
        DishWasher Senna = new DishWasher();
        Rita.soundMade();
        System.out.println("We have made "+ Rita.getPositions() + " positions on our list only of Dishwashers, but we can't find only dishwashers after that");
        Fridge Belarus = new Fridge("Old Blue",5,true,-5,true);
        Fridge Roman = new Fridge();
        MinscFridge Minsk1092 = new MinscFridge("Minsk Old",1,false,-1,false,1092);
        vacuumCleaner ProVac = new vacuumCleaner();
        vacuumCleaner AntiVac = new vacuumCleaner();
        AntiVac.setAmount(25);
        AntiVac.setName("AntiVac");
        AntiVac.soundMade();
        System.out.println("We have "+ Belarus.getFridgeModelsAmount() + " Lab.Fridge models as we made extra counter for them");
        System.out.println("We have " + ProVac.getPositions() + " Positions now and 1 of them is taken by " + AntiVac.getAmount() + " of " + AntiVac.getName());
        Belarus.soundMade();
        System.out.println("Our "+ Belarus.getName() +" Fridges from " + Belarus.getClass() + " get to " + Belarus.getTemp() + " degrees");
        Minsk1092.soundMade();
        System.out.println("Also we can make an Extend of an Extend, e.g. Household -> Lab.Fridge -> MinskFridge with it's own construct and extra fields, like extra model " + Minsk1092.getMinskModel());
    }
}