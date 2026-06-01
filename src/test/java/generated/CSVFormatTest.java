package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class TestCSVFormat {
    @org.junit.jupiter.api.Test
    public void testParse() throws IOException {
        String csvData = "name,email\nJohn Doe,john@example.com";
        Reader in = new StringReader(csvData);
        CSVFormat format = CSVFormat.DEFAULT;

        Iterable<CSVRecord> records = format.parse(in);
        Iterator<CSVRecord> iterator = records.iterator();

        assertTrue(iterator.hasNext());
        CSVRecord record = iterator.next();
        assertEquals("name", record.get(0));
        assertEquals("email", record.get(1));

        assertTrue(iterator.hasNext());
        record = iterator.next();
        assertEquals("John Doe", record.get(0));
        assertEquals("john@example.com", record.get(1));
    }

    @org.junit.jupiter.api.Test
    public void testFormat() {
        CSVFormat format = CSVFormat.DEFAULT;

        String formatted = format.format("John Doe", "john@example.com");
        assertEquals("John Doe,john@example.com", formatted);
    }
}