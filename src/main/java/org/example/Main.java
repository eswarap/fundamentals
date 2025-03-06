package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4,9};
        Arrays.sort(nums);
        System.out.println(largestSum(nums));
    }
    public static int largestSum(int[] num) {
        int sum = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] +  num[i] < sum) {
                sum =num[i - 1] +  num[i];
            }
        }
        return sum;
    }
}