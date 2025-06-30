package org.woven.dsa.search;

import java.util.Arrays;

public class LargestSum {
    // This method finds the largest sum of two adjacent elements in an array without sorting.
    // It iterates through the array and keeps track of the maximum sum found.
    // Time complexity: O(n)
    public static int findWithoutSorting(final int[] num) {
        int sum = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] +  num[i] < sum) {
                sum =num[i - 1] +  num[i];
            }
        }
        return sum;
    }

    /*
        * This method finds the largest sum of two adjacent elements in an array by first sorting the array.
        * It sorts the array and then iterates through it to find the maximum sum of adjacent elements.
        * * Time complexity: O(n log n) due to sorting.
        * * @throws IllegalArgumentException if the input array is null or has fewer than 2 elements.
        * * This implementation assumes that the input array contains at least 2 elements.
        * @param num
        * @return the largest sum of two adjacent elements in the sorted array.
        * * Note: Sorting the array is not necessary for finding the largest sum of two adjacent elements,
        * but it is included here to demonstrate a different approach.
     */
    public static int findWithSorting(final int[] num) {
        Arrays.sort(num);
        int sum = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] +  num[i] < sum) {
                sum =num[i - 1] +  num[i];
            }
        }
        return sum;
    }


    /**
     * Finds the largest sum of a subarray of length k using Kadane's algorithm.
     * This method uses a sliding window approach to calculate the sum of the first k elements,
     * then slides the window across the array to find the maximum sum of any subarray of length k.
     * * Time complexity: O(n)
     * * @throws IllegalArgumentException if the input array is null, has fewer than k elements, or k is less than or equal to 0.
     * * This implementation assumes that the input array contains at least k elements and k is a positive integer.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int kadane(final int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid subarray length");
        }
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        int windowSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
