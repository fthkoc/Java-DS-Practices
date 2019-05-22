package Sort;

import java.util.Arrays;

public class SortTest {
    public static void testSelectionSort() {
        Integer[] testInteger = {9, 5, 7, 6, 2, 3, 1, 4, 8, 0};
        System.out.println("Integer array:");
        System.out.println(Arrays.toString(testInteger));
        Sort.selectionSort(testInteger);
        System.out.println("After selection sort:");
        System.out.println(Arrays.toString(testInteger));
        System.out.println("\n");
    }

    public static void testBubbleSort() {
        Integer[] testInteger = {9, 5, 7, 6, 2, 3, 1, 4, 8, 0};
        System.out.println("Integer array:");
        System.out.println(Arrays.toString(testInteger));
        Sort.bubbleSort(testInteger);
        System.out.println("After bubble sort:");
        System.out.println(Arrays.toString(testInteger));
        System.out.println("\n");
    }

    public static void testInsertionSort() {
        Integer[] testInteger = {9, 5, 7, 6, 2, 3, 1, 4, 8, 0};
        System.out.println("Integer array:");
        System.out.println(Arrays.toString(testInteger));
        Sort.insertionSort(testInteger);
        System.out.println("After insertion sort:");
        System.out.println(Arrays.toString(testInteger));
        System.out.println("\n");
    }

    public static void testShellSort() {
        Integer[] testInteger = {9, 5, 7, 6, 2, 3, 1, 4, 8, 0};
        System.out.println("Integer array:");
        System.out.println(Arrays.toString(testInteger));
        Sort.shellSort(testInteger);
        System.out.println("After shell sort:");
        System.out.println(Arrays.toString(testInteger));
        System.out.println("\n");
    }

    public static void testMergeSort() {
        Integer[] testInteger = {9, 5, 7, 6, 2, 3, 1, 4, 8, 0};
        System.out.println("Integer array:");
        System.out.println(Arrays.toString(testInteger));
        Sort.mergeSort(testInteger);
        System.out.println("After merge sort:");
        System.out.println(Arrays.toString(testInteger));
        System.out.println("\n");
    }

    public static void testHeapSort() {
        Sort sortClass = new Sort();
        Integer[] testInteger = {9, 5, 7, 6, 2, 3, 1, 4, 8, 0};
        System.out.println("Integer array:");
        System.out.println(Arrays.toString(testInteger));
        sortClass.heapSort(testInteger);
        System.out.println("After heap sort:");
        System.out.println(Arrays.toString(testInteger));
        System.out.println("\n");
    }

    public static void testQuickSort() {
        Sort sortClass = new Sort();
        Integer[] testInteger = {9, 5, 7, 6, 2, 3, 1, 4, 8, 0};
        System.out.println("Integer array:");
        System.out.println(Arrays.toString(testInteger));
        sortClass.quickSort(testInteger, 0 , testInteger.length - 1);
        System.out.println("After quick sort:");
        System.out.println(Arrays.toString(testInteger));
        System.out.println("\n");
    }
}
