package Lab7;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TeaParty {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        int runners = 2;
        int sleepMS = 1;
        int[] array = IntStream.rangeClosed(1,100).toArray();
        System.out.println(Arrays.toString(array));
        ExecutorService service = Executors.newCachedThreadPool();
        MyPool runnable = new MyPool();
        runnable.CountSum(Arrays.copyOfRange(array,0,array.length/runners));
        service.submit(runnable);
        MyPool crawlAble = new MyPool();
        crawlAble.CountSum(Arrays.copyOfRange(array,array.length/runners,array.length));
        service.submit(crawlAble);
        service.shutdown();
        while (!service.isTerminated()){
            TimeUnit.MILLISECONDS.sleep(sleepMS);
        }
        System.out.println("Sum of this is " + (crawlAble.getSum() + runnable.getSum()));
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime)/1000000);
    }
}
