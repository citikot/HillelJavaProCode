package lesson12.multithreading.future;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Integer> {
    private int number;

    public FactorialTask(int number) {
        System.out.println("-->" + number);
        this.number = number;
    }

    public Integer call() {
        int factorial = 1;
        if (number < 0)
            throw new IllegalArgumentException("Number must be positive");

        for (int count = number; count > 1; count--) {
            factorial = factorial * count;
        }

        return factorial;
    }
}
