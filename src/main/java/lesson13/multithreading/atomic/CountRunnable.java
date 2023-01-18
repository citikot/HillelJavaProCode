package lesson13.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author spasko
 */
public class CountRunnable implements Runnable {

    private AtomicInteger atomicInteger;
    private String name;

    CountRunnable(AtomicInteger atomicInteger, String name) {
        this.atomicInteger = atomicInteger;
        this.name = name;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d \n", name, atomicInteger.incrementAndGet());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}