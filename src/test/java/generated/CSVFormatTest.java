package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFormatTest {

    @Test
    public void testToString() {
        CSVFormat csvFormat = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null);
        String expected = "Delimiter=<,> Escape=<\\> Encapsulator=<> CommentStart=<#> EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, csvFormat.toString());
    }

    @Test
    public void testWithHeader() {
        CSVFormat csvFormat = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null).withHeader("name", "email", "phone");
        String[] header = csvFormat.getHeader();
        assertEquals(3, header.length);
        assertEquals("name", header[0]);
        assertEquals("email", header[1]);
        assertEquals("phone", header[2]);
    }

    @Test
    public void testWithDelimiter() {
        CSVFormat csvFormat = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null).withDelimiter(';');
        assertEquals(';', csvFormat.getDelimiter());
    }

    @Test
    public void testWithEncapsulator() {
        CSVFormat csvFormat = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null).withEncapsulator('\'');
        assertEquals('\'', csvFormat.getEncapsulator());
    }

    @Test
    public void testWithCommentStart() {
        CSVFormat csvFormat = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null).withCommentStart('$');
        assertEquals('$', csvFormat.getCommentStart());
    }

    @Test
    public void testWithEscape() {
        CSVFormat csvFormat = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null).withEscape('|');
        assertEquals('|', csvFormat.getEscape());
    }

    @Test
    public void testWithSurroundingSpacesIgnored() {
        CSVFormat csvFormat = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null).withSurroundingSpacesIgnored(false);
        assertFalse(csvFormat.isSurroundingSpacesIgnored());
    }

    @Test
    public void testWithEmptyLinesIgnored() {
        CSVFormat csvFormat = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null).withEmptyLinesIgnored(true);
        assertTrue(csvFormat.isEmptyLinesIgnored());
    }

    @Test
    public void testWithLineSeparator() {
        CSVFormat csvFormat = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null).withLineSeparator("\n");
        assertEquals("\n", csvFormat.getLineSeparator());
    }
}