package Lab2;

class MinscFridge extends Fridge{
    private int minskModel;

    public int getMinskModel() {
        return minskModel;
    }
    public void setMinskModel(String minskModelFirst, int minskModelLast) {
        this.setName(minskModelFirst);
        this.minskModel = minskModelLast;
    }
    public void setMinskModel(int minskModelLast, String minskModelFirst){
        this.setName(minskModelFirst);
        this.minskModel = minskModelLast;
    }
    @Override
    public void soundMade(){System.out.println("True minsk sound");}
    public MinscFridge(String x,int y,boolean z, int a, boolean b, int mod) {
        super(x, y, z, a, b);
        this.minskModel = mod;
    }
}