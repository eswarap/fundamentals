package org.woven.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    @Test
    void processDataThrowsExceptionForNullData() {
        DataProcessor processor = new DataProcessor(true);
        assertThrows(IllegalArgumentException.class, () -> processor.processData(null));
    }

    @Test
    void processDataThrowsExceptionForEmptyData() {
        DataProcessor processor = new DataProcessor(true);
        assertThrows(IllegalArgumentException.class, () -> processor.processData("   "));
    }

    @Test
    void processDataThrowsExceptionWhenProcessingDisabled() {
        DataProcessor processor = new DataProcessor(false);
        assertThrows(IllegalStateException.class, () -> processor.processData("valid data"));
    }

    @Test
    void processDataProcessesValidDataWhenEnabled() {
        DataProcessor processor = new DataProcessor(true);
        assertDoesNotThrow(() -> processor.processData("valid data"));
    }
}