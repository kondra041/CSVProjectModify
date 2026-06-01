package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVFormatTest {

    @Test
    void testToString() {
        CSVFormat format = new CSVFormat();
        assertEquals("Delimiter=<,> CommentStart=<#>", format.toString());

        format = new CSVFormat(',');
        assertEquals("Delimiter=<,>", format.toString());
    }

    @Test
    void testWithLineSeparator() {
        CSVFormat format = new CSVFormat().withLineSeparator("\n");
        assertEquals("\n", format.getLineSeparator());
    }

    @Test
    void testParse() throws Exception {
        String data = "name,email\nJohn Doe,jdoe@example.com";
        CSVFormat format = new CSVFormat();
        try (StringReader in = new StringReader(data);
             Iterator<CSVRecord> records = format.parse(in)) {
            assertTrue(records.hasNext());
            assertEquals("name", records.next().get(0));
            assertEquals("email", records.next().get(1));
            assertFalse(records.hasNext());
        }
    }

    @Test
    void testFormat() {
        CSVFormat format = new CSVFormat();
        String formatted = format.format("name", "John Doe", "email", "jdoe@example.com");
        assertEquals("name,John Doe\nemail,jdoe@example.com", formatted);
    }
}