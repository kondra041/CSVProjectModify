package generated;

import java.io.IOException;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CSVPrinterTest {
    
    @Test
    public void testPrint() throws IOException {
        // Set up mock dependencies
        Appendable out = Mockito.mock(Appendable.class);
        CSVFormat format = CSVFormat.DEFAULT;
        
        // Create the printer object and call print on it
        CSVPrinter printer = new CSVPrinter(out, format);
        printer.print("value1", true);
        printer.println();
        printer.print("value2", false);
        printer.println();
        printer.flush();
        
        // Verify that the appropriate methods were called on out
        Mockito.verify(out).append("value1");
        Mockito.verify(out).append(",");
        Mockito.verify(out).append(format.getLineSeparator());
        Mockito.verify(out).append("value2");
        Mockito.verify(out, Mockito.never()).append(",");
        Mockito.verify(out).flush();
    }
    
    @Test
    public void testPrintComment() throws IOException {
        // Set up mock dependencies
        Appendable out = Mockito.mock(Appendable.class);
        CSVFormat format = CSVFormat.DEFAULT;
        
        // Create the printer object and call print on it
        CSVPrinter printer = new CSVPrinter(out, format);
        printer.printComment("my comment");
        printer.println();
        printer.flush();
        
        // Verify that the appropriate methods were called on out
        Mockito.verify(out).append("# my comment");
        Mockito.verify(out).append(format.getLineSeparator());
        Mockito.verify(out).flush();
    }
}