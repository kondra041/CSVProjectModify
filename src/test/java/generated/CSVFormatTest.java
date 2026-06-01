package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;

class CSVFormatTest {
    private final String sampleData = "name,email,phone\nJohn Doe,john@example.com,555-1234\nJane Doe,jane@example.com,555-6789";

    @org.junit.jupiter.api.Test
    void testParse() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT;
        try (Reader in = new java.io.BufferedReader(new java.io.StringReader(sampleData))) {
            Iterable<CSVRecord> records = format.parse(in);
            assertEquals(2, count(records));
            for (CSVRecord record : records) {
                assertAll("Record validation",
                        () -> assertEquals("name", record.getHeaderMap().get("0")),
                        () -> assertEquals("John Doe", record.get("name")),
                        () -> assertEquals("john@example.com", record.get("email")),
                        () -> assertEquals("555-1234", record.get("phone"))
                );
            }
        }
    }

    @org.junit.jupiter.api.Test
    void testFormat() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT;
        String formatted = format.format("John Doe", "john@example.com", "555-1234");
        assertEquals("John Doe,john@example.com,555-1234", formatted);
    }

    private int count(Iterable<?> iterable) {
        int count = 0;
        for (Object obj : iterable) {
            count++;
        }
        return count;
    }
}