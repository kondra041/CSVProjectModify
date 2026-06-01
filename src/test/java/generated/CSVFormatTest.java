package generated;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.io.StringReader;

public class CSVFormatTest {


    @Test
    void testWithDelimiter() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';');
        assertEquals(';', format.getDelimiter());
    }

    @Test
    void testWithEscape() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withEscape('\\');
        assertEquals('\\', format.getEscape());
    }

    @Test
    void testWithEncapsulator() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withEncapsulator('|');
        assertEquals('|', format.getEncapsulator());
    }

    @Test
    void testCommentStart() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withCommentStart('#');
        assertEquals('#', format.getCommentStart());
    }

    @Test
    void testParse() throws IOException {
        String csvContent = "Name,Age\nJohn,30\nJane,25";
        CSVFormat format = CSVFormat.DEFAULT;
        Iterable<CSVRecord> records = format.parse(new StringReader(csvContent));
        assertEquals("John", records.iterator().next().get("Name"));
    }

    @Test
    void testFormat() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT;
        String formatted = format.format("John", "30");
        assertEquals("John,30", formatted);
    }

    @Test
    void testSurroundingSpacesIgnored() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withSurroundingSpacesIgnored();
        assertEquals(true, format.isSurroundingSpacesIgnored());
    }

    @Test
    void testEmptyLinesIgnored() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withEmptyLinesIgnored();
        assertEquals(true, format.isEmptyLinesIgnored());
    }


}