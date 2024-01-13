package Lab2;

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
}