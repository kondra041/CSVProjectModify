package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVFormatTest {

    @Test
    public void testToString() {
        CSVFormat format = new CSVFormat();
        format.setDelimiter(',');
        format.setEscape('\\');
        format.setEncapsulator('"');
        format.setCommentStart('#');
        format.setEmptyLinesIgnored(true);
        format.setSurroundingSpacesIgnored(true);

        String expected = "Delimiter=<,> Escape=<\\> Encapsulator=<\"> CommentStart=<#> EmptyLines:ignored SurroundingSpaces:ignored";
        assertEquals(expected, format.toString());
    }
}