package lesson14.multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author spasko
 */
public class MainLock {

    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource(0);
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 6; i++) {

            Thread t = new Thread(new CountRunnable(commonResource, lock));
            t.setName("Thread " + i);
            t.start();
        }
    }
}
