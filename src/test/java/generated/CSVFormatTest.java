import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.StringReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVFormatTest {

    @org.junit.jupiter.api.Test
    public void testFormat() throws IOException {
        String[] values = {"John Doe", "johndoe@example.com", "555-123-4567"};
        CSVFormat format = CSVFormat.DEFAULT;

        String formattedString = format.format(values);

        assertEquals("John Doe,johndoe@example.com,555-123-4567", formattedString);
    }
}