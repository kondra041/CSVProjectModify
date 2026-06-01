package generated;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.csv.CSVFormat;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.junit.jupiter.api.Test;

public class CSVFormatTest {

    @Test
    public void testFormatWithDefaultValues() {
        CSVFormat format = CSVFormat.DEFAULT;
        String[] values = {"value1", "value2", "value3"};
        String expectedOutput = "\"value1\"\"value2\"\"value3\"";
        assertEquals(expectedOutput, format.format(values));
    }

    @Test
    public void testFormatWithCustomDelimiter() {
        CSVFormat format = new CSVFormat(',', '"', '\0', '\\', true, false, "\n", null);
        String[] values = {"value1", "value2", "value3"};
        String expectedOutput = "\"value1\",\"value2\",\"value3\"";
        assertEquals(expectedOutput, format.format(values));
    }

    @Test
    public void testFormatWithEncapsulator() {
        CSVFormat format = new CSVFormat(',', '"', '\0', '\\', true, false, "\n", null);
        String[] values = {"value1", "value2 with \"quote\"", "value3"};
        String expectedOutput = "\"value1\",\"value2 with \\\"quote\\\",\"value3\"";
        assertEquals(expectedOutput, format.format(values));
    }

    @Test
    public void testFormatWithEscape() {
        CSVFormat format = new CSVFormat(',', '"', '\0', '\\', true, false, "\n", null);
        String[] values = {"value1 with \\backslash\\", "value2", "value3"};
        String expectedOutput = "\"value1 with \\\\backslash\\\\\",\"value2\",\"value3\"";
        assertEquals(expectedOutput, format.format(values));
    }

    @Test
    public void testFormatWithSurroundingSpacesIgnored() {
        CSVFormat format = new CSVFormat(',', '"', '\0', '\\', true, false, "\n", null);
        String[] values = {" value1 ", " value2 ", " value3 "};
        String expectedOutput = "\"value1\",\"value2\",\"value3\"";
        assertEquals(expectedOutput, format.format(values));
    }

    @Test
    public void testFormatWithEmptyLinesIgnored() {
        CSVFormat format = new CSVFormat(',', '"', '\0', '\\', true, true, "\n", null);
        String[] values = {"value1", "", "value3"};
        String expectedOutput = "\"value1\",\"value3\"";
        assertEquals(expectedOutput, format.format(values));
    }

    @Test
    public void testFormatWithCustomLineSeparator() {
        CSVFormat format = new CSVFormat(',', '"', '\0', '\\', true, false, "\r\n", null);
        String[] values = {"value1", "value2", "value3"};
        String expectedOutput = "\"value1\",\"value2\",\"value3\"\r\n";
        assertEquals(expectedOutput, format.format(values));
    }
}