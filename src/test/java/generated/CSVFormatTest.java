import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CSVFormatTest {

    @Test
    public void testWithDelimiterValid() {
        // Test valid delimiters
        assertEquals(CSVFormat.DEFAULT.withDelimiter(','), 
            new CSVFormat(CSVFormat.DEFAULT.getDelimiter(), CSVFormat.DEFAULT.isEscaping(),
                CSVFormat.DEFAULT.isEncapsulating(), CSVFormat.DEFAULT.isCommentingEnabled(),
                CSVFormat.DEFAULT.isSurroundingSpacesIgnored(), CSVFormat.DEFAULT.isEmptyLinesIgnored(),
                CSVFormat.DEFAULT.getLineSeparator(), CSVFormat.DEFAULT.getHeader()));
        
        assertEquals(CSVFormat.DEFAULT.withDelimiter('\t'), 
            new CSVFormat('\t', CSVFormat.DEFAULT.getEscape(), CSVFormat.DEFAULT.isEncapsulating(),
                CSVFormat.DEFAULT.isCommentingEnabled(), CSVFormat.DEFAULT.isSurroundingSpacesIgnored(),
                CSVFormat.DEFAULT.isEmptyLinesIgnored(), CSVFormat.DEFAULT.getLineSeparator(),
                CSVFormat.DEFAULT.getHeader()));
        
        assertEquals(CSVFormat.DEFAULT.withDelimiter(';'), 
            new CSVFormat(';', CSVFormat.DEFAULT.getEscape(), CSVFormat.DEFAULT.isEncapsulating(),
                CSVFormat.DEFAULT.isCommentingEnabled(), CSVFormat.DEFAULT.isSurroundingSpacesIgnored(),
                CSVFormat.DEFAULT.isEmptyLinesIgnored(), CSVFormat.DEFAULT.getLineSeparator(),
                CSVFormat.DEFAULT.getHeader()));
    }

    @Test
    public void testWithDelimiterInvalid() {
        // Test invalid delimiters (line breaks)
        assertThrows(IllegalArgumentException.class, () -> 
            CSVFormat.DEFAULT.withDelimiter('\n'));
        
        assertThrows(IllegalArgumentException.class, () -> 
            CSVFormat.DEFAULT.withDelimiter('\r'));
    }

    @Test
    public void testWithDisabledDelimiter() {
        // Attempt to set delimiter to DISABLED character (should throw)
        assertThrows(IllegalArgumentException.class, () ->
            CSVFormat.DEFAULT.withEscape(CSVFormat.DISABLED));
    }

    @Test
    public void testWithSameDelimiter() {
        // Test same delimiter does not create new instance
        assertSame(CSVFormat.DEFAULT, CSVFormat.DEFAULT.withDelimiter(',').withDelimiter(','));
    }
}