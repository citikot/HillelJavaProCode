package lesson15.sorting;

import java.util.Arrays;

public class MainHeapSort {
    private static void sort(int[] intValues) {
        int n = intValues.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(intValues, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = intValues[0];
            intValues[0] = intValues[i];
            intValues[i] = temp;

            // call max heapify on the reduced heap
            heapify(intValues, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in intValues[]. n is size of heap
    private static void heapify(int[] intValues, int n, int rootIndex) {
        // Initialize largest as root
        int largestIndex = rootIndex;
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;

        // If left child is larger than root
        if (leftIndex < n && intValues[leftIndex] > intValues[largestIndex]) {
            largestIndex = leftIndex;
        }

        // If right child is larger than largest so far
        if (rightIndex < n && intValues[rightIndex] > intValues[largestIndex]) {
            largestIndex = rightIndex;
        }

        // If largest is not root
        if (largestIndex != rootIndex) {
            int swap = intValues[rootIndex];
            intValues[rootIndex] = intValues[largestIndex];
            intValues[largestIndex] = swap;

            // Recursively heapify the affected sub-tree
            heapify(intValues, n, largestIndex);
        }
    }

    public static void main(String[] args) {
        int[] intValues = {5, 1, 4, 2, 8};
        MainHeapSort.sort(intValues);
        System.out.println("Sorted array: " + Arrays.toString(intValues));
    }
}
