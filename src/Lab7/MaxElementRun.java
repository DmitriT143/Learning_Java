package Lab7;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MaxElementRun {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        int[][] matrix = new int[][]{{1,2,9,981,213,123},{3,5,4,212,312,754,900,444,232,533},{7,8,0}};
        int runners = 3;
        int sleepMS = 1;
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(Arrays.deepToString(matrix));

        BitterSeed firstRow = new BitterSeed();
        firstRow.setVector(matrix[0]);
        service.execute(firstRow);

        BitterSeed secondRow = new BitterSeed();
        secondRow.setVector(matrix[1]);
        service.execute(secondRow);

        BitterSeed thirdRow = new BitterSeed();
        thirdRow.setVector(matrix[2]);
        service.execute(thirdRow);

        service.shutdown();
        while (!service.isTerminated()){
            TimeUnit.MILLISECONDS.sleep(sleepMS);
        }
        int[] maxNums = new int[]{firstRow.getMaxSoFar(),secondRow.getMaxSoFar(), thirdRow.getMaxSoFar()};
        System.out.println(Arrays.toString(maxNums));
        for (int i = 0; i < maxNums.length-1; i++) {
            maxNums[0] = Math.max(maxNums[0],maxNums[i]);
        }
        System.out.println("Max number so far " + maxNums[0]);
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime)/1000000);
    }
}
