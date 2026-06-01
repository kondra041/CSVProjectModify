package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFormatTest {

    @Test
    public void testFormat() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';').withEncapsulator('\'');
        String result = format.format("John", "Doe", "john.doe@example.com");
        assertEquals("'John';'Doe';'john.doe@example.com'", result);
    }

    @Test
    public void testFormatWithNoEncapsulation() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';').withEncapsulator(CSVFormat.DISABLED);
        String result = format.format("John", "Doe", "john.doe@example.com");
        assertEquals("John;Doe;john.doe@example.com", result);
    }

    @Test
    public void testFormatWithSpecialCharacters() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';').withEncapsulator('\'');
        String result = format.format("John \"Doe\"", "john.doe@example.com");
        assertEquals("'John \"Doe\"';'john.doe@example.com'", result);
    }

    @Test
    public void testFormatWithLineSeparator() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';').withEncapsulator('\'').withLineSeparator("\n");
        String result = format.format("John", "Doe");
        assertEquals("'John';'Doe'\n", result);
    }
}