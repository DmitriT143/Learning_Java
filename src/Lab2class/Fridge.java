package Lab2class;

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
        Fridge Roman = new Fridge();
        MinscFridge Minsk1092 = new MinscFridge("Minsk Old",1,false,-1,false,"1092");
        vacuumCleaner ProVac = new vacuumCleaner();
        vacuumCleaner AntiVac = new vacuumCleaner();
        AntiVac.setAmount(25);
        AntiVac.setName("AntiVac");
        AntiVac.soundMade();
        System.out.println("We have "+ Belarus.getFridgeModelsAmount() + " Lab.Fridge models as we made extra counter for them");
        System.out.println("We have " + ProVac.getPositions() + " Positions now and 1 of them is taken by " + AntiVac.getAmount() + " of " + AntiVac.getName());
        Belarus.soundMade();
        System.out.println("Our "+ Belarus.getName() +" Fridges from " + Belarus.getClass() + " get to " + Belarus.temp + " degrees");
        Minsk1092.soundMade();
        System.out.println("Also we can make an Extend of an Extend, e.g. Household -> Lab.Fridge -> MinskFridge with it's own construct and extra fields, like extra model " + Minsk1092.getMinskModel());
    }
}