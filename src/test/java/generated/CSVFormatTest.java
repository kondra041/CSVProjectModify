package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CSVFormatTest {


    @Test
    void testToString() {
        CSVFormat format = new CSVFormat.Builder('\t')
                .withEscape('\\').withCommentStart('#')
                .build();
        String expected = "Delimiter=<\\t> Escape=<\\> CommentStart=<#> ";
        assertEquals(expected, format.toString());

    }


}