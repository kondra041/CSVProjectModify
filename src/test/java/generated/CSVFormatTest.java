import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import org.junit.jupiter.api.Test;

public class CSVFormatTest {

    @Test
    public void testDefaultFormat() throws IOException {
        String[] values = {"Name", "Email", "Phone"};
        String expected = "\"Name\",\"Email\",\"Phone\"\n";

        StringWriter out = new StringWriter();
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT)) {
            printer.println(values);
            assertEquals(expected, out.toString().trim());
        }
    }

    @Test
    public void testRFC4180Constants() {
        CSVFormat rfc4180 = CSVFormat.RFC4180;
        assertTrue(rfc4180.getLineSeparator().equals("\n"));
        assertEquals(',', rfc4180.getDelimiter());
        assertFalse(rfc4180.isEscaping());
    }

    @Test
    public void testEXCELHandling() {
        CSVFormat excel = CSVFormat.EXCEL;
        assertEquals("\r\n", excel.getLineSeparator());
        assertEquals(",", excel.getDelimiter());
        assertTrue(excel.isCommentingEnabled());
    }

    @Test
    public void testTDF() throws IOException {
        CSVFormat tdf = CSVFormat.TDF;
        String expectedLineSeparator = "\n";
        String delimiter = "\t";

        StringWriter out = new StringWriter();
        try (CSVPrinter printer = new CSVPrinter(out, tdf)) {
            printer.println("Value1\tValue2");
        }
        assertEquals(expectedLineSeparator + "Value1" + delimiter + "Value2", out.toString().trim());
    }

    @Test
    public void testMYSQL() throws IOException {
        CSVFormat mysql = CSVFormat.MYSQL;
        String expectedLineSeparator = "\n";
        char delimiter = '\t';
        char escape = '\\';

        StringWriter out = new StringWriter();
        try (CSVPrinter printer = new CSVPrinter(out, mysql)) {
            printer.println("Name", "Email", "Phone");
        }
        assertEquals(expectedLineSeparator + "\"Name\"\","Email"\","Phone\"", out.toString().trim());
    }

    @Test
    public void testCustomFormat() throws IOException {
        CSVFormat customFormat = CSVFormat.DEFAULT.withDelimiter(';')
                                                    .withEscape(null)
                                                    .withEncapsulator('\"');
        String expected = "Value1;Value2";

        StringWriter out = new StringWriter();
        try (CSVPrinter printer = new CSVPrinter(out, customFormat)) {
            printer.println("Value1", "Value2");
        }
        assertEquals(expected, out.toString().trim());
    }
}