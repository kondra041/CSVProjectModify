package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CSVPrinterTest {

    @Mock
    private Appendable mockAppendable;

    private CSVFormat format;
    private CSVPrinter printer;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        format = CSVFormat.DEFAULT;
        printer = new CSVPrinter(mockAppendable, format);
    }

    @Test
    void testPrintln() throws IOException {
        String[] values = {"Value1", "Value2"};
        printer.println(values);
        verify(mockAppendable).append(format.getLineSeparator());
    }

    @Test
    void testFlush() throws IOException {
        printer.flush();
        verify(mockAppendable, times(1)).flush();
    }

    @Test
    void testPrintComment() throws IOException {
        String comment = "This is a comment.";
        printer.printComment(comment);
        verify(mockAppendable).append(format.getCommentStart());
        verify(mockAppendable).append(' ');
    }

    @Test
    void testPrint() throws IOException {
        String value = "Test Value";
        printer.print(value);
        verify(mockAppendable, times(1)).append(value);
    }
}