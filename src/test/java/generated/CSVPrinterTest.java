package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import java.io.StringWriter;
import java.io.IOException;

public class CSVPrinterTest {

    @Test
    public void testPrint() throws IOException {
        StringWriter out = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT;
        CSVPrinter printer = new CSVPrinter(out, format);
        
        printer.print("Hello");
        assertEquals("Hello", out.toString());

        printer.print("World");
        assertEquals("Hello,World\n", out.toString());
    }

    @Test
    public void testPrintWithEscape() throws IOException {
        StringWriter out = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT;
        CSVPrinter printer = new CSVPrinter(out, format);
        
        printer.print("Hello World\\n");
        assertEquals("Hello World%n", out.toString());
    }

    @Test
    public void testPrintWithEncapsulation() throws IOException {
        StringWriter out = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT;
        format.setEncapsulator('"');
        CSVPrinter printer = new CSVPrinter(out, format);
        
        printer.print("Hello");
        assertEquals("\"Hello\"", out.toString());
    }

    @Test
    public void testPrintWithComment() throws IOException {
        StringWriter out = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT;
        format.enableComments();
        CSVPrinter printer = new CSVPrinter(out, format);
        
        printer.printComment("This is a comment");
        assertEquals("# This is a comment%n", out.toString());
    }
}