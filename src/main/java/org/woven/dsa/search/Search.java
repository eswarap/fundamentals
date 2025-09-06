package org.woven.dsa.search;

public class Search {
    /**
     * Performs a linear search on an array to find the index of a target value.
     * <p>
     * Iterates through the array and checks each element against the target.
     * Time complexity: O(n), where n is the number of elements in the array.
     * </p>
     *
     * @param arr    the array to search (may be unsorted)
     * @param target the value to search for
     * @return the index of the target value if found; -1 if the target is not present
     * @throws IllegalArgumentException if the input array is null
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
     * <p>
     * Uses a divide-and-conquer approach to efficiently search for the target.
     * Time complexity: O(log n), where n is the number of elements in the array.
     * The input array must be sorted in ascending order.
     * </p>
     *
     * @param arr    the sorted array to search
     * @param target the value to search for
     * @return the index of the target value if found; -1 if the target is not present
     * @throws IllegalArgumentException if the input array is null
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
     * <p>
     * Divides the array into blocks and performs a linear search within the block
     * where the target may be located. Time complexity: O(√n), where n is the number
     * of elements in the array. The input array must be sorted in ascending order.
     * </p>
     *
     * @param arr    the sorted array to search
     * @param target the value to search for
     * @return the index of the target value if found; -1 if the target is not present
     * @throws IllegalArgumentException if the input array is null
     */
    public static int jumpSearch(final int[] arr, final int target) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

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

    /**
     * Performs Fibonacci search on a sorted array to find the index of a target value.
     * * <p>
     *     Uses Fibonacci numbers to divide the array into sections and
     *     searches for the target value.
     *     Time complexity: O(log n), where n is the number of elements in the array.
     *     The input array must be sorted in ascending order.
     *     </p>
     *     @param arr    the sorted array to search
     *     @param target the value to search for
     *     @return the index of the target value if found; -1 if the target is not present
     *     @throws IllegalArgumentException if the input array is null
     *
     *
     */
    public static int fibonacciSearch(final int[] arr, final int target) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        int n = arr.length;
        int fibM2 = 0; // (m-2)'th Fibonacci number
        int fibM1 = 1; // (m-1)'th Fibonacci number
        int fibM = fibM2 + fibM1; // m'th Fibonacci number

        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibM2, n - 1);
            if (arr[i] < target) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibM2;
                fibM1 -= fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return i; // Return the index of the target
            }
        }

        if (fibM1 == 1 && arr[offset + 1] == target) {
            return offset + 1; // Return the index of the target
        }

        return -1; // Return -1 if the target is not found
    }
}
