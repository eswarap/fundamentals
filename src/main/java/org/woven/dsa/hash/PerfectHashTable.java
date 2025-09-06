package org.woven.dsa.hash;

import java.util.List;
import java.util.Map;

public class PerfectHashTable {
    private final Map<String, Integer> perfectMap = Map.of(
            "red", 0,
            "green", 1,
            "blue", 2,
            "yellow", 3
    );

    private final String[] table = new String[4];

    public static void main(String[] args) {
        var hashTable = new PerfectHashTable();
        List.of("red", "green", "blue", "yellow").forEach(hashTable::insert);
        hashTable.display();
    }

    public void insert(String key) {
        Integer index = perfectMap.get(key);
        if (index != null) {
            table[index] = key;
        } else {
            System.out.println("Key not supported in perfect hash.");
        }
    }

    public void display() {
        for (int i = 0; i < table.length; i++) {
            System.out.printf("Bucket %d: %s%n", i, table[i]);
        }
    }
}
