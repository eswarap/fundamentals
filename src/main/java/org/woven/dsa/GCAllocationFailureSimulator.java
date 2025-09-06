package org.woven.dsa;

import java.util.ArrayList;
import java.util.List;

public class GCAllocationFailureSimulator {
    public static void main(String[] args) {
        List<byte[]> memoryConsumers = new ArrayList<>();

        try {
            while (true) {
                // Allocate 1MB chunks repeatedly
                byte[] chunk = new byte[1024 * 1024];
                memoryConsumers.add(chunk);

                // Optional: slow down allocation slightly
                Thread.sleep(10);
            }
        } catch (OutOfMemoryError e) {
            System.err.println("💥 OutOfMemoryError triggered!");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted.");
        }
    }
}

