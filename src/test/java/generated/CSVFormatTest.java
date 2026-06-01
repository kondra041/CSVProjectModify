package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.apache.commons.csv.CSVFormat;

import java.io.StringReader;
import java.util.Iterator;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

public class CSVFormatTest {

    @Test
    public void testParse() throws Exception {
        String csvData = "John,Doe,30\nJane,Smith,25";
        StringReader reader = new StringReader(csvData);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
        Iterator<CSVRecord> iterator = records.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("John", iterator.next().get(0));
    }

    @Test
    public void testFormat() {
        String[] values = {"John", "Doe", "30"};
        String formatted = CSVFormat.DEFAULT.format(values);
        assertEquals("\"John\",\"Doe\",\"30\"", formatted);
    }

    @Test
    public void testToString() {
        CSVFormat format = new CSVFormat(';', '\"', '#');
        String expected = "Delimiter=<;> Encapsulator=<\"> CommentStart=<#>";
        assertEquals(expected, format.toString());
    }
}