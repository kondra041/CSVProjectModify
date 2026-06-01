package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

class CSVPrinterTest {

    @Test
    void testPrintln() throws IOException {
        CSVPrinter printer = new CSVPrinter(new StringBuilder(), CSVFormat.DEFAULT);
        printer.println("one", "two");
        
        String result = ((StringBuilder) mockOutputCapture(printer)).toString();
        assertEquals("one,two\r\n", result);
    }

    @Test
    void testPrintlnNull() throws IOException {
        CSVPrinter printer = new CSVPrinter(new StringBuilder(), CSVFormat.DEFAULT);
        printer.println(null, "two");
        
        String result = ((StringBuilder) mockOutputCapture(printer)).toString();
        assertEquals(",two\r\n", result);
    }

    @Test
    void testEncapsulation() throws IOException {
        CSVFormat format = CSVFormat.builder()
            .setIsEncapsulating(true)
            .build();
        CSVPrinter printer = new CSVPrinter(new StringBuilder(), format);
        
        String input = "Hello \"World\", this is a test";
        printer.println(input);
        
        String result = ((StringBuilder) mockOutputCapture(printer)).toString();
        assertEquals("\"Hello \\\"World\\\", this is a test\"\r\n", result);
    }

    @Test
    void testEscaping() throws IOException {
        CSVFormat format = CSVFormat.builder()
            .setIsEscaping(true)
            .build();
        CSVPrinter printer = new CSVPrinter(new StringBuilder(), format);
        
        String input = "Line1\nLine2\rColumn";
        printer.println(input);
        
        String result = ((StringBuilder) mockOutputCapture(printer)).toString();
        assertEquals("Line1\\nLine2\\rColumn\r\n", result);
    }

    @Test
    void testComment() throws IOException {
        CSVFormat format = CSVFormat.builder()
            .setIsCommentingEnabled(true)
            .build();
        CSVPrinter printer = new CSVPrinter(new StringBuilder(), format);
        
        String comment = "This is a multi-line comment\nSecond line";
        printer.printComment(comment);
        
        String result = ((StringBuilder) mockOutputCapture(printer)).toString();
        assertEquals("# This is a multi-line comment\r\n# Second line\r\n", result);
    }

    private <T> T mockOutputCapture(CSVPrinter printer) {
        Appendable out = printer.getOut();
        if (out instanceof StringBuilder) {
            return (StringBuilder) out;
        }
        // Mock the Appendable to capture written content
        StringBuilder sb = new StringBuilder();
        when(out.append(anyChar())).thenAnswer(invocation -> {
            char c = (char) invocation.getArgument(0);
            sb.append(c);
            return out;
        });
        when(out.append(anyString())).thenAnswer(invocation -> {
            String s = (String) invocation.getArgument(0);
            sb.append(s);
            return out;
        });
        return sb;
    }
}