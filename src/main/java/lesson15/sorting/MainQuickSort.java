package lesson15.sorting;

import java.util.Arrays;

public class MainQuickSort {
    // A utility function to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * This function takes last element as pivot, places
     * the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     */
    private static int partition(int[] intValues, int startIndex, int endIndex) {

        // pivot
        int pivot = intValues[endIndex];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {

            // If current element is smaller
            // than the pivot
            if (intValues[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(intValues, i, j);
            }
        }
        swap(intValues, i + 1, endIndex);
        return i + 1;
    }

    private static void sort(int[] intValues, int startIndex, int endIndex) {
        if (startIndex < endIndex) {

            int partitionIndex = partition(intValues, startIndex, endIndex);

            // Separately sort elements before
            // partition and after partition
            sort(intValues, startIndex, partitionIndex - 1);
            sort(intValues, partitionIndex + 1, endIndex);
        }
    }

    private static void sort(int[] intValues) {
        sort(intValues, 0, intValues.length - 1);
    }

    public static void main(String[] args) {
        int[] intValues = {5, 1, 4, 2, 8};
        MainQuickSort.sort(intValues);
        System.out.println("Sorted array: " + Arrays.toString(intValues));
    }
}
