package lesson14.multithreading.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author spasko
 */
public class CountRunnable implements Runnable {

    private CommonResource commonResource;
    private Lock locker;

    CountRunnable(CommonResource commonResource, Lock lock) {
        this.commonResource = commonResource;
        locker = lock;
    }

    public void run() {
        // set lock
        locker.lock();
        try {
            for (int i = 0; i < 5; i++) {
                commonResource.incrementValue();
                System.out.printf("%s %d \n", Thread.currentThread()
                        .getName(), commonResource.getValue());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            // set unlock to resource
            locker.unlock();
        }
    }
}