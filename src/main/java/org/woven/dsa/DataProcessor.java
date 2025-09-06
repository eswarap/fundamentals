package org.woven.dsa;

public class DataProcessor {

    private final boolean isProcessingEnabled;

    public DataProcessor(boolean isProcessingEnabled) {
        this.isProcessingEnabled = isProcessingEnabled;
    }

    public void processData(String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid data provided: data cannot be null or empty");
        }

        if (!isProcessingEnabled) {
            throw new IllegalStateException("Data processing is not enabled");
        }

        // Original logic for processing data
        // ...
    }
}
