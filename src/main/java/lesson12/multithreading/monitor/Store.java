package lesson12.multithreading.monitor;

public class Store {
    private int product = 0;

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Consumer bouth 1 product");
        System.out.println("Goods on the warehouse " + product);
        notify();
    }

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Produser added 1 product");
        System.out.println("Goods on the warehouse " + product);
        notify();
    }
}
