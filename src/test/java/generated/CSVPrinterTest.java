package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class CSVPrinterTest {

    private StringWriter writer;
    private CSVPrinter printer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withCommentMarker('#');
        printer = new CSVPrinter(writer, format);
    }

    @Test
    void testPrintWithEscape() throws IOException {
        printer.print("Hello, world!", true);
        printer.println();

        assertEquals("Hello\\, world!\n", writer.toString());
    }

    @Test
    void testPrintWithoutEscape() throws IOException {
        printer.print("Hello world", false);
        printer.println();

        assertEquals("Hello world\n", writer.toString());
    }
}