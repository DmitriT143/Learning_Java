package Lab7;

public class BitterSeed implements Runnable {
    private int MaxSoFar = 0;
    public int[] array;

    public void setVector(int[] array) {this.array = array;}

    public int getMaxSoFar() {return MaxSoFar;}

    @Override
    public void run(){
        if (array.length!=1&&array.length!=0){
            for (int i = 0; i < array.length-1; i++) {
                MaxSoFar = Math.max(MaxSoFar,array[i]);
                System.out.println("Currently Max " + getMaxSoFar());
            }
        }
    }
}
