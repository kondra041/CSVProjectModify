package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVFormatTest {

    @Test
    public void testToString() {
        CSVFormat csv = new CSVFormat(',', '"', '#', '\\', false, true, "\n", null);
        String expected = "Delimiter=<,> \n" +
                "Escape=<\\> \n" +
                "Encapsulator=<\">";
        assertEquals(expected, csv.toString());
    }

    @Test
    public void testToStringWithAllOptions() {
        CSVFormat csv = new CSVFormat(',', '"', '#', '\\', true, false, "\r\n", null);
        String expected = "Delimiter=<,> \n" +
                "Escape=<\\> \n" +
                "Encapsulator=<\"> \n" +
                "CommentStart=<#> \n" +
                "EmptyLines:ignored \n" +
                "SurroundingSpaces:ignored";
        assertEquals(expected, csv.toString());
    }

    @Test
    public void testWithDelimiter() {
        CSVFormat csv = new CSVFormat().withDelimiter(';');
        assertEquals(';', csv.getDelimiter());
    }

    @Test
    public void testWithEncapsulator() {
        CSVFormat csv = new CSVFormat().withEncapsulator('"');
        assertEquals('"', csv.getEncapsulator());
    }

    @Test
    public void testIsCommentingEnabled() {
        CSVFormat csv = new CSVFormat('#', '"', '#', '\\', false, true, "\n", null);
        assertTrue(csv.isCommentingEnabled());
    }

    @Test
    public void testIsEscaping() {
        CSVFormat csv = new CSVFormat(',', '"', '#', '\\', false, true, "\n", null);
        assertFalse(csv.isEscaping());
    }

    @Test
    public void testWithEmptyLinesIgnored() {
        CSVFormat csv = new CSVFormat().withEmptyLinesIgnored(true);
        assertTrue(csv.isEmptyLinesIgnored());
    }

    @Test
    public void testIsSurroundingSpacesIgnored() {
        CSVFormat csv = new CSVFormat().withSurroundingSpacesIgnored(true);
        assertTrue(csv.isSurroundingSpacesIgnored());
    }
}