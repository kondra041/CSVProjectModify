package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVPrinterTest {

    private StringWriter stringWriter;
    private CSVPrinter csvPrinter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        csvPrinter = new CSVPrinter(stringWriter, CSVFormat.DEFAULT);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPrintNullValue() throws IOException {
        csvPrinter.print((String) null);
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testPrintEmptyValue() throws IOException {
        csvPrinter.print("");
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testPrintStringValueWithoutEscape() throws IOException {
        String value = "testValue";
        csvPrinter.print(value, false);
        assertEquals(value, stringWriter.toString().trim());
    }

    @Test
    public void testPrintStringValueWithEscape() throws IOException {
        String value = "test,Value";
        csvPrinter.print(value);
        assertEquals("\"test,Value\"", stringWriter.toString().trim());
    }
}