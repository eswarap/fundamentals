package org.woven.dsa.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashCollisionDemo {
    public static void main(String[] args) {
        int bucketCount = 10;
        int inputCount = 15;
        Map<Integer, List<String>> hashTable = new HashMap<>();

        for (int i = 0; i < inputCount; i++) {
            String input = "input_" + i;
            int hash = Math.abs(input.hashCode()) % bucketCount;
            hashTable.computeIfAbsent(hash, k -> new ArrayList<>()).add(input);
        }
        System.out.println("Hash Table:");
        hashTable.forEach((key, value) -> System.out.printf("Bucket %d: %s%n", key, value));

        System.out.println("\nCollisions:");
        hashTable.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> System.out.printf("Bucket %d has %d collisions%n",
                        entry.getKey(), entry.getValue().size() - 1));
    }
}
