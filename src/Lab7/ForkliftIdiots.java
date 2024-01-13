package Lab7;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkliftIdiots {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        int[] array = IntStream.rangeClosed(0,10000).toArray();
        ValueCounter counter = new ValueCounter(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
        System.out.println(forkJoinPool.invoke(counter));
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime)/1000000);
    }
}
