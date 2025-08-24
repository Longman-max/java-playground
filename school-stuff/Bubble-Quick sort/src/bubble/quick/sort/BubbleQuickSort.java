package bubble.quick.sort;

import java.util.Arrays;

/**
 *
 * Name: Agbai Obasi Uwa
 * Registration number: 20231411752
 * Department: Computer Science
 * Group No: 1
 * S/N: 7
 */

public class BubbleQuickSort {

    // Bubble Sort implementation
    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort implementation
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // left side
            quickSort(arr, pi + 1, high); // right side
        }
    }

    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                // Swap
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        String[] studentNames = {"Obasi", "Chioma", "Emeka", "Ada", "Blessing", "Kingsley", "Ngozi"};

        // Copy arrays so each algorithm sorts the same unsorted data
        String[] bubbleArray = Arrays.copyOf(studentNames, studentNames.length);
        String[] quickArray = Arrays.copyOf(studentNames, studentNames.length);

        // Measure Bubble Sort
        long startBubble = System.nanoTime();
        bubbleSort(bubbleArray);
        long endBubble = System.nanoTime();

        // Measure Quick Sort
        long startQuick = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        long endQuick = System.nanoTime();

        // Print results
        System.out.println("Original Array: " + Arrays.toString(studentNames));
        System.out.println("Bubble Sorted:  " + Arrays.toString(bubbleArray));
        System.out.println("Quick Sorted:   " + Arrays.toString(quickArray));

        System.out.println("\nPerformance:");
        System.out.println("Bubble Sort Time: " + (endBubble - startBubble) + " ns");
        System.out.println("Quick Sort Time:  " + (endQuick - startQuick) + " ns");
    }
}
