package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CSVFormatTest {

    private CSVFormat csvFormat;

    @BeforeEach
    void setUp() {
        csvFormat = CSVFormat.DEFAULT;
    }

    @Test
    void testWithDelimiter_ValidDelimiter_SetsDelimiter() throws IOException {
        char newDelimiter = ';';
        CSVFormat updatedCSVFormat = csvFormat.withDelimiter(newDelimiter);

        assertEquals(newDelimiter, updatedCSVFormat.getDelimiter(), "The delimiter should be set to the specified character.");
        assertNotEquals(csvFormat.getDelimiter(), updatedCSVFormat.getDelimiter(), "The original and updated CSV formats should have different delimiters.");
    }

    @Test
    void testWithDelimiter_LineBreakDelimiter_ThrowsException() {
        char lineBreakDelimiter = '\n';
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            csvFormat.withDelimiter(lineBreakDelimiter);
        });

        String expectedMessage = "The delimiter cannot be a line break";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should contain: " + expectedMessage);
    }

    @Test
    void testWithDelimiter_NullPointerException_ThrowsException() {
        // This is to ensure that any internal null references are caught during method execution.
        Exception exception = assertDoesNotThrow(() -> csvFormat.withDelimiter(','));
        
        assertNotNull(exception, "No exception should be thrown when using a valid delimiter.");
    }

    @Test
    void testWithDelimiter_DuplicateCall_ReturnsDifferentInstances() {
        CSVFormat firstInstance = csvFormat.withDelimiter(';');
        CSVFormat secondInstance = firstInstance.withDelimiter(',');

        assertNotSame(firstInstance, secondInstance, "Calling withDelimiter should return different instances for each call.");
    }
}