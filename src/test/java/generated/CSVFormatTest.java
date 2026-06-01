package generated;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Iterator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVFormatTest {

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() {
        csvFormat = new CSVFormat(',', '"', '#', '\\', false, true, "\r\n", null);
    }

    @Test
    public void testGetDelimiter() {
        assertEquals(',', csvFormat.getDelimiter());
    }

    @Test
    public void testWithDelimiter() {
        char delimiter = '|';
        CSVFormat newFormat = csvFormat.withDelimiter(delimiter);
        assertNotSame(csvFormat, newFormat);
        assertEquals(delimiter, newFormat.getDelimiter());
    }

    @Test
    public void testGetEncapsulator() {
        assertEquals('"', csvFormat.getEncapsulator());
    }

    @Test
    public void testWithEncapsulator() {
        char encapsulator = '\'';
        CSVFormat newFormat = csvFormat.withEncapsulator(encapsulator);
        assertNotSame(csvFormat, newFormat);
        assertEquals(encapsulator, newFormat.getEncapsulator());
    }

    @Test
    public void testGetCommentStart() {
        assertEquals('#', csvFormat.getCommentStart());
    }

    @Test
    public void testWithCommentStart() {
        char commentStart = '@';
        CSVFormat newFormat = csvFormat.withCommentStart(commentStart);
        assertNotSame(csvFormat, newFormat);
        assertEquals(commentStart, newFormat.getCommentStart());
    }

    @Test
    public void testGetEscape() {
        assertEquals('\\', csvFormat.getEscape());
    }

    @Test
    public void testWithEscape() {
        char escape = '^';
        CSVFormat newFormat = csvFormat.withEscape(escape);
        assertNotSame(csvFormat, newFormat);
        assertEquals(escape, newFormat.getEscape());
    }

    @Test
    public void testIsSurroundingSpacesIgnored() {
        assertTrue(csvFormat.isSurroundingSpacesIgnored());
    }

    @Test
    public void testWithSurroundingSpacesIgnoredTrue() {
        boolean surroundingSpacesIgnored = true;
        CSVFormat newFormat = csvFormat.withSurroundingSpacesIgnored(surroundingSpacesIgnored);
        assertNotSame(csvFormat, newFormat);
        assertTrue(newFormat.isSurroundingSpacesIgnored());
    }

    @Test
    public void testWithSurroundingSpacesIgnoredFalse() {
        boolean surroundingSpacesIgnored = false;
        CSVFormat newFormat = csvFormat.withSurroundingSpacesIgnored(surroundingSpacesIgnored);
        assertNotSame(csvFormat, newFormat);
        assertFalse(newFormat.isSurroundingSpacesIgnored());
    }

    @Test
    public void testIsEmptyLinesIgnored() {
        assertTrue(csvFormat.isEmptyLinesIgnored());
    }

    @Test
    public void testWithEmptyLinesIgnoredTrue() {
        boolean emptyLinesIgnored = true;
        CSVFormat newFormat = csvFormat.withEmptyLinesIgnored(emptyLinesIgnored);
        assertNotSame(csvFormat, newFormat);
        assertTrue(newFormat.isEmptyLinesIgnored());
    }

    @Test
    public void testWithEmptyLinesIgnoredFalse() {
        boolean emptyLinesIgnored = false;
        CSVFormat newFormat = csvFormat.withEmptyLinesIgnored(emptyLinesIgnored);
        assertNotSame(csvFormat, newFormat);
        assertFalse(newFormat.isEmptyLinesIgnored());
    }

    @Test
    public void testGetLineSeparator() {
        assertEquals("\r\n", csvFormat.getLineSeparator());
    }

    @Test
    public void testWithLineSeparator() {
        String lineSeparator = "\n";
        CSVFormat newFormat = csvFormat.withLineSeparator(lineSeparator);
        assertNotSame(csvFormat, newFormat);
        assertEquals(lineSeparator, newFormat.getLineSeparator());
    }

    @Test
    public void testParseMockReader() throws IOException {
        Reader mockReader = mock(Reader.class);
        when(mockReader.read()).thenReturn(-1); // End of file

        Iterator<CSVRecord> records = csvFormat.parse(mockReader).iterator();

        assertFalse(records.hasNext());

        verify(mockReader, times(1)).read();
    }

    @Test
    public void testFormat() {
        String expectedOutput = "value1,value2";
        assertEquals(expectedOutput, csvFormat.format(" value1 ", " value2 "));
    }
}