package Lab2class;

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