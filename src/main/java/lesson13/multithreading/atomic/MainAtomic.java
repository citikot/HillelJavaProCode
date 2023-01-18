package lesson13.multithreading.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author spasko
 */
public class MainAtomic {

    public static void main(String args[]) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Start threads");

        // add and start thread
        executorService.execute(new CountRunnable(atomicInteger, "A"));
        executorService.execute(new CountRunnable(atomicInteger, "B"));
        executorService.execute(new CountRunnable(atomicInteger, "C"));
        executorService.execute(new CountRunnable(atomicInteger, "D"));

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End threads");
    }
}
