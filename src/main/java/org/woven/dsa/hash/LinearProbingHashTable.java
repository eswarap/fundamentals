package org.woven.dsa.hash;

import java.util.List;

public class LinearProbingHashTable {
    private final String[] table;
    private final int size;

    public LinearProbingHashTable(int size) {
        this.size = size;
        this.table = new String[size];
    }

    public static void main(String[] args) {
        var hashTable = new LinearProbingHashTable(7);
        List.of("cat", "dog", "bird", "fish", "ant", "bat", "cow").forEach(hashTable::insert);
        hashTable.display();
    }

    public void insert(String key) {
        int index = Math.abs(key.hashCode()) % size;
        while (table[index] != null) {
            index = (index + 1) % size;
        }
        table[index] = key;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.printf("Bucket %d: %s%n", i, table[i]);
        }
    }
}
