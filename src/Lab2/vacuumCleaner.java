package Lab2;

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