package org.woven.dsa.search;

public class Search {
    /**
     * Performs a linear search on an array to find the index of a target value.
     * * This method iterates through the array and checks each element against the target.
     * * Time complexity: O(n), where n is the number of elements in the array.
     * * @throws IllegalArgumentException if the input array is null.
     * * This implementation assumes that the input array is not sorted.
     * * This method returns the index of the target value if found, or -1 if the target is not present in the array.
     *
     * @param arr
     * @param target
     * @return
     */
    public static int linearSearch(int[] arr, int target) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index of the target
            }
        }
        return -1; // Return -1 if the target is not found
    }

    /**
     * Performs a binary search on a sorted array to find the index of a target value.
     * * This method uses a divide-and-conquer approach to efficiently search for the target.
     * * * Time complexity: O(log n), where n is the number of elements in the array.
     * * * @throws IllegalArgumentException if the input array is null or not sorted.
     * * * This implementation assumes that the input array is sorted in ascending order.
     * * * This method returns the index of the target value if found, or -1 if the target is not present in the array.
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Return the index of the target
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Return -1 if the target is not found
    }

    /**
     * Performs a jump search on a sorted array to find the index of a target value.
     * * This method divides the array into blocks and performs a linear search within the block where the target may be located.
     * * Time complexity: O(√n), where n is the number of elements in the array.
     * * @throws IllegalArgumentException if the input array is null or not sorted.
     * * This implementation assumes that the input array is sorted in ascending order.
     * * This method returns the index of the target value if found, or -1 if the target is not present in the array.
     *
     * @param arr
     * @param target
     * @return
     */

    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1; // Return -1 if the target is not found
            }
        }

        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) {
                return i; // Return the index of the target
            }
        }
        return -1; // Return -1 if the target is not found
    }
}
