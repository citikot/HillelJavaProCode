package lesson15.sorting;

import java.util.Arrays;

public class MainSelectionSort {
    private static void sort(int[] intValues) {
        int n = intValues.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (intValues[j] < intValues[minIndex])
                    minIndex = j;

            // Swap the found minimum element with the first
            // element
            int temp = intValues[minIndex];
            intValues[minIndex] = intValues[i];
            intValues[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] intValues = {5, 1, 4, 2, 8};
        MainSelectionSort.sort(intValues);
        System.out.println("Sorted array: " + Arrays.toString(intValues));
    }
}
