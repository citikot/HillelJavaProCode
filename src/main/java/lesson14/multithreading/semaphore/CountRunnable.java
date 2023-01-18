package lesson14.multithreading.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author spasko
 */
public class CountRunnable implements Runnable {

    private CommonResource commonResource;
    private Semaphore semaphore;
    private String name;

    public CountRunnable(CommonResource commonResource, Semaphore sem, String name) {
        this.commonResource = commonResource;
        this.semaphore = sem;
        this.name = name;
    }

    public void run() {

        try {
            System.out.println(name + " starting");
            semaphore.acquire();
            for (int i = 0; i < 5; i++) {
                commonResource.incrementValue();
                System.out.println(this.name + ": " + commonResource.getValue());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " end work");
        semaphore.release();
    }
}
