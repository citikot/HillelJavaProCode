package lesson15.sorting;

import java.util.Arrays;

public class MainBubbleSort {
    private static void sort(int[] intValues) {
        int n = intValues.length - 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - i; j++)
                if (intValues[j] > intValues[j + 1]) {
                    // swap intValues[j+1] and intValues[j]
                    int temp = intValues[j];
                    intValues[j] = intValues[j + 1];
                    intValues[j + 1] = temp;
                }
    }

    public static void main(String[] args) {
        int[] intValues = {5, 1, 4, 2, 8};
        MainBubbleSort.sort(intValues);
        System.out.println("Sorted array: " + Arrays.toString(intValues));
    }
}
