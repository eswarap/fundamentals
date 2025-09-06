package org.woven.dsa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RecursiveTask;

public class CommonPoolExample {
    private static final Logger log = LoggerFactory.getLogger(CommonPoolExample.class);

    static class SumTask extends RecursiveTask<Long>{
        private final long[] numbers;
        private final int start,end;
        private static final int THRESHOLD = 1_000;

        public SumTask(long[] numbers, int start, int end){
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += numbers[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask left = new SumTask(numbers, start, mid);
                SumTask right = new SumTask(numbers, mid, end);
                left.fork(); // Fork the left task
                long rightResult = right.compute(); // Compute the right task directly
                long leftResult = left.join(); // Join the left task
                return leftResult + rightResult; // Combine results
            }
        }
    }

    public static void main(String[] args) {
        long[] numbers = new long[10_000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // Fill with numbers 1 to 10 million
        }

        SumTask task = new SumTask(numbers, 0, numbers.length);
        long result = task.fork().join(); // Fork and join the task
        log.info("Sum: " + result); // Output the result
    }
}
