package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;

class CSVFormatTest {

    @Test
    void testWithDelimiter() {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';');
        assertEquals(';', format.getDelimiter());

        IllegalArgumentException exception =
                catchThrowable(() -> format.withDelimiter('\n'));
        assertTrue(exception instanceof IllegalArgumentException);
        assertEquals("The delimiter cannot be a line break", exception.getMessage());
    }

    @Test
    void testWithEncapsulator() {
        CSVFormat format = CSVFormat.DEFAULT.withEncapsulator('\'');
        assertEquals('\'', format.getEncapsulator());

        IllegalArgumentException exception =
                catchThrowable(() -> format.withEncapsulator('\n'));
        assertTrue(exception instanceof IllegalArgumentException);
        assertEquals("The encapsulator cannot be a line break", exception.getMessage());
    }

    @Test
    void testWithCommentStart() {
        CSVFormat format = CSVFormat.DEFAULT.withCommentStart('#');
        assertEquals('#', format.getCommentStart());

        IllegalArgumentException exception =
                catchThrowable(() -> format.withCommentStart('\n'));
        assertTrue(exception instanceof IllegalArgumentException);
        assertEquals("The comment start character cannot be a line break", exception.getMessage());
    }

    @Test
    void testWithEscape() {
        CSVFormat format = CSVFormat.DEFAULT.withEscape('\\');
        assertEquals('\\', format.getEscape());

        IllegalArgumentException exception =
                catchThrowable(() -> format.withEscape('\n'));
        assertTrue(exception instanceof IllegalArgumentException);
        assertEquals("The escape character cannot be a line break", exception.getMessage());
    }

    @Test
    void testWithSurroundingSpacesIgnored() {
        CSVFormat format = CSVFormat.DEFAULT.withSurroundingSpacesIgnored(true);
        assertTrue(format.isSurroundingSpacesIgnored());

        CSVFormat format2 = format.withSurroundingSpacesIgnored(false);
        assertFalse(format2.isSurroundingSpacesIgnored());
    }

    @Test
    void testWithEmptyLinesIgnored() {
        CSVFormat format = CSVFormat.DEFAULT.withEmptyLinesIgnored(true);
        assertTrue(format.isEmptyLinesIgnored());

        CSVFormat format2 = format.withEmptyLinesIgnored(false);
        assertFalse(format2.isEmptyLinesIgnored());
    }

    @Test
    void testWithLineSeparator() {
        String lineSeparator = "\r\n";
        CSVFormat format = CSVFormat.DEFAULT.withLineSeparator(lineSeparator);
        assertEquals(lineSeparator, format.getLineSeparator());

        CSVFormat format2 = CSVFormat.DEFAULT.withHeader().withLineSeparator("\n");
        assertEquals("\n", format2.getLineSeparator());
    }

    @Test
    void testWithHeader() {
        String[] header = {"name", "email", "phone"};
        CSVFormat format = CSVFormat.DEFAULT.withHeader(header);
        assertArrayEquals(header, format.getHeader());

        CSVFormat format2 = CSVFormat.DEFAULT.withHeader("name", "email", "phone");
        assertEquals(Arrays.asList(header), Arrays.asList(format2.getHeader()));
    }

    @Test
    void testParse() throws IOException {
        String input =
                "John Doe,john.doe@example.com,555-1234\n" +
                "Jane Smith,jane.smith@example.com,\n";
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(new StringReader(input));

        Iterator<CSVRecord> iterator = records.iterator();
        CSVRecord record1 = iterator.next();
        assertArrayEquals(new String[]{"John Doe", "john.doe@example.com", "555-1234"}, record1.getRecord());

        CSVRecord record2 = iterator.next();
        assertArrayEquals(new String[]{"Jane Smith", "jane.smith@example.com", ""}, record2.getRecord());
    }

    @Test
    void testFormat() {
        String[] values = {"John Doe", "john.doe@example.com", "555-1234"};
        CSVFormat format = CSVFormat.DEFAULT;
        assertEquals("John Doe,john.doe@example.com,555-1234", format.format(values));
    }

    @Test
    void testToString() {
        CSVFormat format = CSVFormat.DEFAULT;
        String expected = "Delimiter=<>, EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }
}