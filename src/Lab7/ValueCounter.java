package Lab7;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ValueCounter extends RecursiveTask<Integer>{

    private int[] array;

    public ValueCounter (int[] array){
        this.array = array;
    }

    @Override
        protected Integer compute(){
        if( array.length <= 150){
            System.out.println("Gello " + array[0] + " Range " + array[array.length-1] + " Sums up to "+ Arrays.stream(array).sum());
            //System.out.printf("Task %s execute in thread %s%n", this,Thread.currentThread().getName());
            return Arrays.stream(array).sum();
        }
        ValueCounter firstPartArrayValueCounter = new ValueCounter(Arrays.copyOfRange(array, 0, 150));
        ValueCounter otherPartArrayValueCounter = new ValueCounter(Arrays.copyOfRange(array, 150, array.length));
        firstPartArrayValueCounter.fork();
        otherPartArrayValueCounter.fork();
        return firstPartArrayValueCounter.join() + otherPartArrayValueCounter.join();
    }
}
