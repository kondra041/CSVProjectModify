package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CSVFormatTest {

    @Test
    public void testToString() {
        CSVFormat format = new CSVFormat(',', '"', '#', '\\', true, true, "\n", new String[]{"name", "email", "phone"});
        String expected = "Delimiter=<,> Escape=<> Encapsulator=<\"> CommentStart=<#> EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }

    @Test
    public void testToStringWithDefaults() {
        CSVFormat format = CSVFormat.DEFAULT;
        String expected = "Delimiter=<,> Escape=<> Encapsulator=<\"> CommentStart=<#> EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }

    @Test
    public void testToStringWithCustomDelimiter() {
        CSVFormat format = new CSVFormat(';', '"', '#', '\\', true, true, "\n", new String[]{"name", "email", "phone"});
        String expected = "Delimiter=<;> Escape=<> Encapsulator=<\"> CommentStart=<#> EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }

    @Test
    public void testToStringWithNoComment() {
        CSVFormat format = new CSVFormat(',', '"', '\0', '\\', true, true, "\n", new String[]{"name", "email", "phone"});
        String expected = "Delimiter=<,> Escape=<> Encapsulator=<\"> EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }

    @Test
    public void testToStringWithNoEscape() {
        CSVFormat format = new CSVFormat(',', '"', '#', '\0', true, true, "\n", new String[]{"name", "email", "phone"});
        String expected = "Delimiter=<,> Encapsulator=<\"> CommentStart=<#> EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }

    @Test
    public void testToStringWithNoEncapsulation() {
        CSVFormat format = new CSVFormat(',', '\0', '#', '\\', true, true, "\n", new String[]{"name", "email", "phone"});
        String expected = "Delimiter=<,> Escape=<> CommentStart=<#> EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }

    @Test
    public void testToStringWithNoEmptyLineSkipping() {
        CSVFormat format = new CSVFormat(',', '"', '#', '\\', true, false, "\n", new String[]{"name", "email", "phone"});
        String expected = "Delimiter=<,> Escape=<> Encapsulator=<\"> CommentStart=<#> SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }

    @Test
    public void testToStringWithNoSpaceTrimming() {
        CSVFormat format = new CSVFormat(',', '"', '#', '\\', false, true, "\n", new String[]{"name", "email", "phone"});
        String expected = "Delimiter=<,> Escape=<> Encapsulator=<\"> CommentStart=<#> EmptyLines:ignored";
        assertEquals(expected, format.toString());
    }
}