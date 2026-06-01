package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVPrinterTest {
    @org.junit.jupiter.api.Test
    public void testPrintln() throws IOException {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT;
        CSVPrinter printer = new CSVPrinter(writer, format);

        printer.println("value1", "value2", "value3");

        assertEquals("value1,value2,value3\n", writer.toString());
    }
}