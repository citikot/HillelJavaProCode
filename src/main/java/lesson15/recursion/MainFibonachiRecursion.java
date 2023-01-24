package lesson15.recursion;

/**
 * @author spasko
 */
public class MainFibonachiRecursion {
    public static void main(String[] args) {
        // 0->1->1->2->3->5->8->13->
        long timePoint = System.nanoTime();
        int elementNumber = 40;
        System.out.println("By math method: " + getElementFibonachi(elementNumber));
        System.out.println("By math method, time: " + (System.nanoTime() - timePoint));

        timePoint = System.nanoTime();
        System.out.println("By recursion method: " + getElementFibonachiRecursion(elementNumber));
        System.out.println("By recursion method, time : " + (System.nanoTime() - timePoint));
    }

    static int getElementFibonachi(int number) {
        int valuePrev = 0;
        if (number == 0)
            return valuePrev;
        int valueNext = 1;
        for (int i = 2; i < number; i++) {
            int temp = valueNext;
            valueNext += valuePrev;
            valuePrev = temp;
        }
        return valueNext;
    }

    static int getElementFibonachiRecursion(int number) {
        if (number <= 2)
            return number - 1;
        return getElementFibonachiRecursion(number - 2) + getElementFibonachiRecursion(number - 1);
    }

    static int getElementFibonachiOptimized(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int[] fibonachiElements = new int[n + 1]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1 */
        fibonachiElements[0] = 0;
        fibonachiElements[1] = 1;

        for (i = 2; i <= n; i++) {
            /*
             * Add the previous 2 numbers in the series
             * and store it
             */
            fibonachiElements[i] = fibonachiElements[i - 1] + fibonachiElements[i - 2];
        }

        return fibonachiElements[n-1];
    }

}
