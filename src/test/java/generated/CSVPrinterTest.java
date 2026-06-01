import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.StringWriter;

public class CSVPrinterTest {

    private CSVPrinter csvPrinter;
    private StringWriter stringWriter;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        csvPrinter = new CSVPrinter(stringWriter, CSVFormat.DEFAULT);
    }

    @org.junit.jupiter.api.Test
    public void testPrintln() throws IOException {
        csvPrinter.println("Hello", "World");
        String expectedOutput = "Hello,World\n";
        assertEquals(expectedOutput, stringWriter.toString());
    }

    @org.junit.jupiter.api.Test
    public void testPrintComment() throws IOException {
        csvPrinter.printComment("This is a comment");
        String expectedOutput = "# This is a comment\n";
        assertEquals(expectedOutput, stringWriter.toString());
    }
}