import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CSVFormatTest {

    @InjectMocks
    private CSVFormat csvFormat;

    @Test
    void testDefaultFormat() {
        String expected = "Delimiter=<,> Escape=<\\> Encapsulator=<\"> CommentStart=<#> EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, CSVFormat.DEFAULT.toString());
    }

    @Test
    void testCustomDelimiter() {
        CSVFormat format = CSVFormat.newFormat('\t');
        String expected = "Delimiter=<\t>";
        assertEquals(expected, format.toString());
    }

    @Test
    void testEscapingDisabled() {
        CSVFormat format = CSVFormat.newFormat(',', (char) -1);
        String expected = "Delimiter=<,> Encapsulator=<\">";
        assertEquals(expected, format.toString());
    }

    @Test
    void testCommentingEnabled() {
        CSVFormat format = CSVFormat.EXCEL;
        String expected = "Delimiter=<;> Escape=<\\> Encapsulator=<\"> CommentStart=<#>";
        assertEquals(expected, format.toString());
    }

    @Test
    void testWithHeaderAndLineSeparator() throws IOException {
        CSVFormat format = CSVFormat.newFormat(',', (char) -1)
                .withHeader("name", "email")
                .withLineSeparator("\n");
        String expected = "Delimiter=<,> Escape=<!> Header=<name,email> LineSeparator=<\n>";
        assertEquals(expected, format.toString());
    }

    @Test
    void testEmptyLinesIgnored() {
        CSVFormat format = CSVFormat.DEFAULT.withEmptyLinesIgnored(true);
        String expected = "Delimiter=<,> Escape=<\\> Encapsulator=<\"> CommentStart=<#> EmptyLines:ignored";
        assertEquals(expected, format.toString());
    }

    @Test
    void testSurroundingSpacesIgnored() {
        CSVFormat format = CSVFormat.DEFAULT.withSurroundingSpacesIgnored(true);
        String expected = "Delimiter=<,> Escape=<\\> Encapsulator=<\"> CommentStart=<#> SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }
}