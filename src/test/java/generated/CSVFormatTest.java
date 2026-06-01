package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVFormatTest {

    @Test
    public void testWithDelimiter_ValidCharacter() {
        CSVFormat format = new CSVFormat(',', '"', '#', '\\', false, false, "\r\n", null);
        CSVFormat updatedFormat = format.withDelimiter(';');
        
        assertEquals(';', updatedFormat.getDelimiter());
    }

    @Test
    public void testWithDelimiter_LineBreakCharacterThrowsException() {
        CSVFormat format = new CSVFormat(',', '"', '#', '\\', false, false, "\r\n", null);
        
        assertThrows(IllegalArgumentException.class, () -> {
            format.withDelimiter('\n');
        });
    }
}