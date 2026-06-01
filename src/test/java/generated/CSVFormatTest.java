package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CSVFormatTest {

    private CSVFormat format;
    private Reader reader;

    @BeforeAll
    void setUp() throws IOException {
        format = new CSVFormat(';');
        reader = new StringReader("field1;field2;field3\nvalue1;value2;value3");
    }

    @Test
    void testParse() throws IOException {
        CSVParser parser = new CSVParser(reader, format);
        Iterable<CSVRecord> records = parser.getRecords();
        assertNotNull(records);
        assertTrue(parser.hasNext());

        CSVRecord record = parser.next();
        assertEquals("value1", record.get("field1"));
        assertEquals("value2", record.get("field2"));
        assertEquals("value3", record.get("field3"));
    }

    @Test
    void testFormat() {
        String formatted = format.format("value1", "value2", "value3");
        assertEquals("value1;value2;value3\n", formatted);
    }
}