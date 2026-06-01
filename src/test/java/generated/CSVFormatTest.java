import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import java.io.StringWriter;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVFormatTest {

    @Test
    public void testFormat() {
        // Arrange
        String[] values = {"John", "john@example.com", "1234567890"};
        CSVFormat format = CSVFormat.DEFAULT;
        
        // Act
        String result = format.format(values);
        
        // Assert
        assertEquals("John,john@example.com,1234567890", result);
    }
}