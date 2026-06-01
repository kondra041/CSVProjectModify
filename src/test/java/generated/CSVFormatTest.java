package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.QuoteMode;
import org.apache.commons.csv.writer.CSVWriter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.StringReader;
import java.io.StringWriter;

public class CSVFormatTest {

    @Test
    public void testCSVFormat() {
        CSVFormat csvFormat = new CSVFormat.Builder().build();

        String[] values = {"Hello", "World"};
        StringWriter out = new StringWriter();
        try {
            new CSVPrinter(out, csvFormat).println(values);
        } catch (Exception e) {
            // should not happen
        }
        assertEquals("Hello,World\n", out.toString());
    }

    @Test
    public void testCSVFormatWithDelimiter() {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(';');
        String[] values = {"Hello"; "World"};
        StringWriter out = new StringWriter();
        try {
            new CSVPrinter(out, csvFormat).println(values);
        } catch (Exception e) {
            // should not happen
        }
        assertEquals("Hello;World\n", out.toString());
    }

    @Test
    public void testCSVFormatWithEncapsulator() {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withEncapsulator('"');
        String[] values = {"Hello"; "World"};
        StringWriter out = new StringWriter();
        try {
            new CSVPrinter(out, csvFormat).println(values);
        } catch (Exception e) {
            // should not happen
        }
        assertEquals("\"Hello\",\"World\"\n", out.toString());
    }

    @Test
    public void testCSVParser() {
        String input = "Hello,World";
        CSVParser parser = new CSVParser(new StringReader(input), CSVFormat.DEFAULT);
        Iterable<org.apache.commons.csv.CSVRecord> records = parser.getRecords();
        for (org.apache.commons.csv.CSVRecord record : records) {
            assertEquals("Hello", record.get(0));
            assertEquals("World", record.get(1));
        }
    }

    @Test
    public void testCSVPrinter() {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter out = new StringWriter();
        try {
            new CSVPrinter(out, csvFormat).println("Hello", "World");
        } catch (Exception e) {
            // should not happen
        }
        assertEquals("Hello,World\n", out.toString());
    }
}