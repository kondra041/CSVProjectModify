package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CSVPrinterTest {

    @Mock
    private Appendable out;

    private CSVFormat format;
    private CSVPrinter csvPrinter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        format = CSVFormat.DEFAULT;
        csvPrinter = new CSVPrinter(out, format);
    }

    @Test
    public void testPrintln() throws IOException {
        csvPrinter.println();
        verify(out).append(format.getLineSeparator());
    }

    @Test
    public void testFlush() throws IOException {
        Flushable flushableOut = (Flushable) out;
        csvPrinter.flush();
        verify(flushableOut).flush();
    }

    @Test
    public void testPrintlnWithValues() throws IOException {
        String[] values = {"value1", "value2"};
        when(out.append("value1")).thenReturn(out);
        when(out.append(format.getDelimiter())).thenReturn(out);
        when(out.append("value2")).thenReturn(out);
        when(out.append(format.getLineSeparator())).thenReturn(out);

        csvPrinter.println(values);

        verifySequenceOfAppends();
    }

    @Test
    public void testPrintCommentWithCommentsEnabled() throws IOException {
        format = CSVFormat.DEFAULT.builder().setCommentStart('#').build();
        csvPrinter = new CSVPrinter(out, format);
        String comment = "This is a comment";

        when(out.append(format.getCommentStart())).thenReturn(out).thenReturn(out);
        when(out.append(' ')).thenReturn(out).thenReturn(out);
        when(out.append(comment)).thenReturn(out);

        csvPrinter.printComment(comment);

        verifySequenceOfAppends();
    }

    @Test
    public void testPrintCommentWithCommentsDisabled() throws IOException {
        format = CSVFormat.DEFAULT.builder().setCommentStart('#').setDisableComments(true).build();
        csvPrinter = new CSVPrinter(out, format);
        String comment = "This is a comment";

        csvPrinter.printComment(comment);

        verifyNoInteractions(out);
    }

    @Test
    public void testPrintWithCheckForEscapeTrue() throws IOException {
        String value = "value";
        when(out.append(format.getDelimiter())).thenReturn(out);
        when(out.append(value)).thenReturn(out);

        csvPrinter.print(value, true);

        verifySequenceOfAppends();
    }

    @Test
    public void testPrintWithCheckForEscapeFalse() throws IOException {
        String value = "value";
        when(out.append(format.getDelimiter())).thenReturn(out);
        when(out.append(value)).thenReturn(out);

        csvPrinter.print(value, false);

        verifySequenceOfAppends();
    }

    private void verifySequenceOfAppends() throws IOException {
        InOrder inOrder = Mockito.inOrder(out);
        inOrder.verify(out).append(format.getDelimiter());
        inOrder.verify(out).append("value1");
        inOrder.verify(out).append(format.getDelimiter());
        inOrder.verify(out).append("value2");
        inOrder.verify(out).append(format.getLineSeparator());
    }
}