package lesson13.multithreading.volotile;

public class MainVolatile {
    private static volatile int intVariableBetweenThreads = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int localValue = intVariableBetweenThreads;
            while (localValue < 50) {
                if (localValue != intVariableBetweenThreads) {
                    System.out.println("Got Change for MY_INT : " + intVariableBetweenThreads);
                    localValue = intVariableBetweenThreads;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int localValue = intVariableBetweenThreads;
            while (intVariableBetweenThreads < 50) {
                System.out.println("Incrementing MY_INT to " + (localValue + 1));
                intVariableBetweenThreads = ++localValue;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}