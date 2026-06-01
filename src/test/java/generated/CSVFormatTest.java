import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVFormatTest {

    private static final char DELIMITER = ',';
    private static final char ENCAPSULATOR = '"';
    private static final char ESCAPE = '\\';
    private static final String[] HEADER = {"name", "email", "phone"};
    private static final String LINE_SEPARATOR = "\n";

    @org.junit.jupiter.api.Test
    public void testWithDelimiter() {
        CSVFormat format = new CSVFormat(DELIMITER, ENCAPSULATOR, ESCAPE);

        // Test with a valid delimiter character
        CSVFormat formattedFormat = format.withDelimiter('a');
        assertEquals('a', formattedFormat.delimiter());

        // Test with an invalid delimiter character (line break)
        try {
            format.withDelimiter('\n');
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @org.junit.jupiter.api.Test
    public void testFormat() throws IOException {
        CSVFormat format = new CSVFormat(DELIMITER, ENCAPSULATOR, ESCAPE);

        String formattedString = format.format(HEADER);

        StringWriter out = new StringWriter();
        new CSVPrinter(out, format).println(HEADER);

        assertEquals(out.toString().trim(), formattedString);
    }

    @org.junit.jupiter.api.Test
    public void testParse() throws IOException {
        CSVFormat format = new CSVFormat(DELIMITER, ENCAPSULATOR, ESCAPE);

        Reader reader = new StringReader("name,email,phone");
        Iterable<CSVRecord> records = format.parse(reader);

        for (CSVRecord record : records) {
            assertEquals(HEADER, record.getValues());
        }
    }
}