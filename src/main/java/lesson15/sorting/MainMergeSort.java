package lesson15.sorting;

import java.util.Arrays;

public class MainMergeSort {

    private static void merge(int[] intValues, int startIndex, int delimeterIndex, int endIndex) {
        // Find sizes of two subarrays to be merged
        int leftLength = delimeterIndex - startIndex + 1;
        int rightLength = endIndex - delimeterIndex;

        /* Create temp arrays */
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        /* Copy data to temp arrays */
        for (int i = 0; i < leftLength; i++) {
            left[i] = intValues[startIndex + i];
        }
        for (int j = 0; j < rightLength; j++) {
            right[j] = intValues[delimeterIndex + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // Initial index of merged subarray array
        int k = startIndex;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                intValues[k] = left[i];
                i++;
            } else {
                intValues[k] = right[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of left[] if any */
        while (i < leftLength) {
            intValues[k] = left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of right[] if any */
        while (j < rightLength) {
            intValues[k] = right[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private static void sort(int[] intValues, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // Find the middle point
            int delimeterIndex = (endIndex + startIndex) / 2;

            // Sort first and second halves
            sort(intValues, startIndex, delimeterIndex);
            sort(intValues, delimeterIndex + 1, endIndex);

            // Merge the sorted halves
            merge(intValues, startIndex, delimeterIndex, endIndex);
        }
    }

    private static void sort(int[] intValues) {
        sort(intValues, 0, intValues.length - 1);
    }

    public static void main(String[] args) {
        int[] intValues = {5, 1, 4, 2, 8};
        MainMergeSort.sort(intValues);
        System.out.println("Sorted array: " + Arrays.toString(intValues));
    }
}
