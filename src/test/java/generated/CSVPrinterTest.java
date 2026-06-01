package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVPrinterTest {

    @Mock
    private Appendable out;

    private CSVPrinter csvPrinter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        csvPrinter = new CSVPrinter(out, CSVFormat.DEFAULT);
    }

    @Test
    public void testPrint_nullValue() throws IOException {
        csvPrinter.print(null, true);
        verify(out).append("");
    }

    @Test
    public void testPrint_nonNullValue_noEscape() throws IOException {
        String value = "test";
        csvPrinter.print(value, false);
        verify(out).append("test");
    }

    @Test
    public void testPrint_nonNullValue_withEscape() throws IOException {
        String value = "te,st";
        csvPrinter.print(value, true);
        verify(out).append("te\\,st");
    }

    @Test
    public void testPrintNewLine() throws IOException {
        csvPrinter.println();
        verify(out).append(CSVFormat.DEFAULT.getLineSeparator());
    }
}