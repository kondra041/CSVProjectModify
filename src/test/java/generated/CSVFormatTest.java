package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CSVFormatTest {

    @Test
    void testWithDelimiter() {
        // Arrange
        char newDelimiter = '|';
        CSVFormat originalFormat = new CSVFormat(',', '"', '\0', '\\', true, false, "\n", null);

        // Act
        CSVFormat modifiedFormat = originalFormat.withDelimiter(newDelimiter);

        // Assert
        assertNotNull(modifiedFormat);
        assertEquals(newDelimiter, modifiedFormat.getDelimiter());
    }

    @Test
    void testWithDelimiterThrowsIllegalArgumentException() {
        // Arrange
        char lineBreakDelimiter = '\n';
        CSVFormat originalFormat = new CSVFormat(',', '"', '\0', '\\', true, false, "\n", null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> originalFormat.withDelimiter(lineBreakDelimiter));
    }
}