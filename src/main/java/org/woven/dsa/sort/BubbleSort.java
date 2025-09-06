package org.woven.dsa.sort;

public class BubbleSort {

    /**
     * Sorts an array using the Bubble Sort algorithm.
     * <p>     * This method repeatedly steps through the list, compares adjacent elements,
     * swapping them if they are in the wrong order.
     * * The pass through the list is repeated until the list is sorted.
     * * Time complexity: O(n^2), where n is the number of elements in the array.
     * * @throws IllegalArgumentException if the input array is null
     * * This implementation assumes that the input array is not null and contains at least one element.
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
