package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFormatTest {

    @Test
    public void testWithDelimiter() {
        // Arrange
        char delimiter = ',';
        CSVFormat csvFormat = new CSVFormat(delimiter, CSVFormat.DEFAULT.getEncapsulator(), CSVFormat.DEFAULT.getCommentStart(), CSVFormat.DEFAULT.getEscape(), CSVFormat.DEFAULT.isSurroundingSpacesIgnored(), CSVFormat.DEFAULT.isEmptyLinesIgnored(), CSVFormat.DEFAULT.getLineSeparator(), CSVFormat.DEFAULT.getHeader());

        // Act
        CSVFormat result = csvFormat.withDelimiter(delimiter);

        // Assert
        assertEquals(CSVFormat.DEFAULT, result);
    }
}