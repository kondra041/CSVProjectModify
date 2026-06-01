import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;

public class CSVFormatTest {

    @Test
    public void testToString() {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(',')
                .withEscape('"')
                .withEncapsulator('"')
                .withCommentStart('#')
                .withEmptyLinesIgnored(true)
                .withSurroundingSpacesIgnored(true);

        String expected = "Delimiter=<,> Escape=<\"> Encapsulator=<\"> CommentStart=<#> EmptyLines:ignored SurroundingSpaces:ignored";

        assertEquals(expected, format.toString());
    }
}