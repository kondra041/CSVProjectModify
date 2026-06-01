package generated;

// IMPORTS GO HERE
import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

public class CSVFormatTests {
    @Test
    public void testParseAndFormat() throws IOException {
        // Given
        String csvData = "John,Doe,123 Main St\nJane,Doe,456 Elm St";
        StringReader reader = new StringReader(csvData);
        CSVFormat format = CSVFormat.DEFAULT;

        // When
        Iterable<CSVRecord> records = format.parse(reader);
        Iterator<CSVRecord> iterator = records.iterator();

        // Then
        assertTrue(iterator.hasNext());
        CSVRecord record1 = iterator.next();
        assertEquals("John", record1.get(0));
        assertEquals("Doe", record1.get(1));
        assertEquals("123 Main St", record1.get(2));

        assertTrue(iterator.hasNext());
        CSVRecord record2 = iterator.next();
        assertEquals("Jane", record2.get(0));
        assertEquals("Doe", record2.get(1));
        assertEquals("456 Elm St", record2.get(2));

        assertFalse(iterator.hasNext());

        // When formatting
        String formattedCsv = format.format("Alice", "Smith", "789 Oak St");

        // Then the formatted string should match the expected CSV line
        assertEquals("Alice,Smith,\"789 Oak St\"", formattedCsv);
    }
}