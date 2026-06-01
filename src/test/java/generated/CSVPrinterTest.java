package generated;

import java.io.IOException;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CSVPrinterTest {

    @Test
    void testPrintWithCheckForEscapeTrue() throws IOException {
        Appendable mockAppendable = mock(Appendable.class);
        CSVFormat mockCSVFormat = mock(CSVFormat.class);

        when(mockCSVFormat.isEncapsulating()).thenReturn(false);
        when(mockCSVFormat.isEscaping()).thenReturn(true);
        when(mockCSVFormat.getDelimiter()).thenReturn(',');
        when(mockCSVFormat.getEscape()).thenReturn('\\');

        CSVPrinter csvPrinter = new CSVPrinter(mockAppendable, mockCSVFormat);

        assertDoesNotThrow(() -> {
            csvPrinter.print("value\nwith\nnewlines", true);
        });

        verify(mockAppendable).append(anyString());
    }

    @Test
    void testPrintWithCheckForEscapeFalse() throws IOException {
        Appendable mockAppendable = mock(Appendable.class);
        CSVFormat mockCSVFormat = mock(CSVFormat.class);

        when(mockCSVFormat.isEncapsulating()).thenReturn(false);
        when(mockCSVFormat.isEscaping()).thenReturn(true);
        when(mockCSVFormat.getDelimiter()).thenReturn(',');

        CSVPrinter csvPrinter = new CSVPrinter(mockAppendable, mockCSVFormat);

        assertDoesNotThrow(() -> {
            csvPrinter.print("value\nwith\nnewlines", false);
        });

        verify(mockAppendable).append("value\nwith\nnewlines");
    }

    @Test
    void testPrintNullValueWithCheckForEscapeTrue() throws IOException {
        Appendable mockAppendable = mock(Appendable.class);
        CSVFormat mockCSVFormat = mock(CSVFormat.class);

        when(mockCSVFormat.isEncapsulating()).thenReturn(false);
        when(mockCSVFormat.isEscaping()).thenReturn(true);

        CSVPrinter csvPrinter = new CSVPrinter(mockAppendable, mockCSVFormat);

        assertDoesNotThrow(() -> {
            csvPrinter.print(null, true);
        });

        verify(mockAppendable).append("");
    }

    @Test
    void testPrintNullValueWithCheckForEscapeFalse() throws IOException {
        Appendable mockAppendable = mock(Appendable.class);
        CSVFormat mockCSVFormat = mock(CSVFormat.class);

        when(mockCSVFormat.isEncapsulating()).thenReturn(false);

        CSVPrinter csvPrinter = new CSVPrinter(mockAppendable, mockCSVFormat);

        assertDoesNotThrow(() -> {
            csvPrinter.print(null, false);
        });

        verify(mockAppendable).append("");
    }

    @Test
    void testPrintWithInvalidState() throws IOException {
        Appendable mockAppendable = mock(Appendable.class);
        CSVFormat mockCSVFormat = mock(CSVFormat.class);

        when(mockCSVFormat.isEncapsulating()).thenReturn(true);
        doThrow(new IllegalStateException("Invalid state")).when(mockAppendable).append(anyString());

        CSVPrinter csvPrinter = new CSVPrinter(mockAppendable, mockCSVFormat);

        assertThrows(IllegalStateException.class, () -> {
            csvPrinter.print("value", true);
        });
    }
}