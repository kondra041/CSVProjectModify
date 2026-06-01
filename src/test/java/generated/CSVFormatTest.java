package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFormatTest {

    @Test
    void testFormatSimpleValues() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withHeader("name", "email");
        String formatted = format.format("John Doe", "john.doe@example.com");

        assertEquals("\"John Doe\",\"john.doe@example.com\"\r\n", formatted);
    }

    @Test
    void testFormatValuesWithDifferentDelimiter() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';').withHeader("name", "email");
        String formatted = format.format("Jane Doe", "jane.doe@example.com");

        assertEquals("\"Jane Doe\";\"jane.doe@example.com\"\r\n", formatted);
    }

    @Test
    void testFormatValuesWithEncapsulation() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withHeader("name", "email");
        String valueWithComma = "John, Doe";
        String formatted = format.format(valueWithComma, "john.doe@example.com");

        assertEquals("\"" + valueWithComma + "\",\"john.doe@example.com\"\r\n", formatted);
    }

    @Test
    void testFormatValuesWithEscaping() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withHeader("name", "email");
        String escapingValue = "John\\Doe";
        String formatted = format.format(escapingValue, "john.doe@example.com");

        assertEquals("\"John\\\\Doe\",\"john.doe@example.com\"\r\n", formatted);
    }
}