package generated;

import java.io.Serializable;
import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFormatTest {

    @Test
    void testToString() {
        // Test with DISABLED settings
        CSVFormat pristine = new CSVFormat(CSVFormat.DISABLED, CSVFormat.DISABLED, 
                                           CSVFormat.DISABLED, CSVFormat.DISABLED, false, false, null, null);
        assertEquals("Delimiter=<￿>", pristine.toString());

        // Test with custom settings
        CSVFormat custom = pristine.withDelimiter(',').withEscape('\\')
                                   .withEncapsulator('"').withCommentStart('#')
                                   .withSurroundingSpacesIgnored(true).withEmptyLinesIgnored(true)
                                   .withLineSeparator(CSVFormat.CRLF);
        assertEquals("Delimiter=<,> Escape=\\ Encapsulator=\" CommentStart=# EmptyLines:ignored SurroundingSpaces:ignored", 
                     custom.toString());
    }
}