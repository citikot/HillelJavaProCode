package lesson13.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author spasko
 */
public class MainExecutor {

    public static void main(String args[]) {

        CommonResource commonResource = new CommonResource(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Start threads");

        // add and start thread
        executorService.execute(new CountRunnable(commonResource, "A"));
        executorService.execute(new CountRunnable(commonResource, "B"));
        executorService.execute(new CountRunnable(commonResource, "C"));
        executorService.execute(new CountRunnable(commonResource, "D"));

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End threads");
    }
}
