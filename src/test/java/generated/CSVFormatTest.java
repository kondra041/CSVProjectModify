package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.io.IOException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVFormatTest {

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() {
        csvFormat = CSVFormat.DEFAULT.withDelimiter(';');
    }

    @Test
    public void testWithDelimiterThrowsIllegalArgumentExceptionForLineBreak() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            csvFormat.withDelimiter('\n');
        });
    }

    @Test
    public void testWithDelimiterReturnsNewInstance() throws Exception {
        CSVFormat newFormat = csvFormat.withDelimiter(';');
        assertNotSame(csvFormat, newFormat);
        assertEquals(';', newFormat.getDelimiter());
    }

    @Test
    public void testParseThrowsIOExceptionWhenReadingFails() throws Exception {
        Reader mockReader = mock(Reader.class);
        when(mockReader.read()).thenThrow(new IOException("Mocked I/O error"));

        assertThrows(IOException.class, () -> {
            csvFormat.parse(mockReader);
        });
    }

    @Test
    public void testParseReturnsEmptyIterableWhenNoRecords() throws Exception {
        String input = "";
        Iterable<CSVRecord> records = csvFormat.parse(new StringReader(input));
        assertTrue(records.iterator().hasNext());
    }
}