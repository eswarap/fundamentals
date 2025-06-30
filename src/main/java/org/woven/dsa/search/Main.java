package org.woven.dsa.search;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Main {
    public static void main(String[] args) {
        final int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4,9};
        log.info("Largest sum with sorting {}", LargestSum.findWithSorting(nums));
        log.info("Largest sum without sorting {}", LargestSum.findWithoutSorting(nums));
        log.info("Largest sum with Kadane's algorithm {}", LargestSum.kadane(nums,2));
    }
}