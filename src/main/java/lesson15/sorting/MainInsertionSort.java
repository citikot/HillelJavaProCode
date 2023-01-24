package lesson15.sorting;

import java.util.Arrays;

public class MainInsertionSort {
    private static void sort(int[] intValues) {

        for (int i = 1; i < intValues.length; i++) {
            int key = intValues[i];
            int j = i - 1;

            /*
             * Move elements of intValues[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && intValues[j] > key) {
                intValues[j + 1] = intValues[j];
                j = j - 1;
            }

            intValues[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] intValues = {5, 1, 4, 2, 8};
        MainInsertionSort.sort(intValues);
        System.out.println("Sorted array: " + Arrays.toString(intValues));
    }
}
