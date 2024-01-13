package Lab7;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.IntStream;

class MyPool implements Runnable {
    public int i = 0;
    private int[] array;
    private int sum = 0;
    public void CountSum(int[] array){
        this.array = array;
    }
    @Override
    public void run(){
        calculateSum();
    }
    private void calculateSum(){
        while (i < array.length){
            sum += array[i];
            i= i+1;
            System.out.println(sum + " из списка от " + array[0] + " До " +array[array.length-1]);
        }
    }
    public int getSum(){
        return sum;
    }
}
class Chai {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        int runners = 5;
        int sleepMS = 1;
        int[] array = IntStream.rangeClosed(1,10).toArray();
        System.out.println(Arrays.toString(array));
        ExecutorService service = Executors.newCachedThreadPool();
        MyPool runnable = new MyPool();
        for (int i = 0; i < runners; i++) {
            int[] miniArray = Arrays.copyOfRange(array, i * (array.length / runners), (i + 1) * (array.length / runners));
            runnable = new MyPool();
            runnable.CountSum(miniArray);
            service.execute(runnable);
        }
        service.shutdown();
        while(!service.isTerminated()){TimeUnit.MILLISECONDS.sleep(sleepMS);}
        System.out.println("Sum " + runnable.getSum());
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime)/1000000);
    }
}