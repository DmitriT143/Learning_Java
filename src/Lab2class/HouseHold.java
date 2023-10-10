package Lab2class;

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