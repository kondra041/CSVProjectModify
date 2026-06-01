package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVFormatTest {

    @Test
    public void testWithDelimiter() {
        // Arrange
        char delimiter = ',';
        CSVFormat format = new CSVFormat();

        // Act
        CSVFormat result = format.withDelimiter(delimiter);

        // Assert
        assertNotNull(result);
        assertEquals(delimiter, result.getDelimiter());
    }

    @Test
    public void testWithDelimiterThrowsExceptionForLineBreak() {
        // Arrange
        char delimiter = '\n'; // Line break character
        CSVFormat format = new CSVFormat();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            format.withDelimiter(delimiter);
        });
    }
}