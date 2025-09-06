package org.woven.dsa.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ChainingHashTable {

    private final Map<Integer, List<String>> table = new HashMap<>();
    private final int bucketCount;

    public ChainingHashTable(int bucketCount) {
        this.bucketCount = bucketCount;
    }

    public static void main(String[] args) {
        ChainingHashTable hashTable = new ChainingHashTable(10);
        List.of("apple", "banana", "grape", "melon", "peach", "berry").forEach(hashTable::insert);
        hashTable.display();
    }

    public void insert(String key) {
        int hash = Math.abs(key.hashCode()) % bucketCount;
        table.computeIfAbsent(hash, k -> new LinkedList<>()).add(key);
    }

    public void display() {
        table.forEach((bucket, entries) ->
                System.out.printf("Bucket %d: %s%n", bucket, entries));
    }
}
