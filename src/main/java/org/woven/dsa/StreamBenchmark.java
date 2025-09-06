package org.woven.dsa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;

public class StreamBenchmark {
    
    private static final Logger log = LoggerFactory.getLogger(StreamBenchmark.class);
    
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
                .boxed()
                .toList();
        System.gc();

        // Sequential Stream
        long startSeq = System.nanoTime();
        long sumSeq = numbers.stream()
                .mapToLong(n -> (long) n * n)
                .sum();
        long endSeq = System.nanoTime();
        log.info("Sequential sum: " + sumSeq);
        log.info("Time (ms): " + (endSeq - startSeq) / 1_000_000);
        System.gc();
        // Parallel Stream
        long startPar = System.nanoTime();
        long sumPar = numbers.parallelStream()
                .mapToLong(n -> (long) n * n)
                .sum();
        long endPar = System.nanoTime();
        log.info("Parallel sum: " + sumPar);
        log.info("Time (ms): " + (endPar - startPar) / 1_000_000);

    }
}
