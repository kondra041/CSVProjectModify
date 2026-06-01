package generated;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.Test;

public class CSVFormatGeneratedTest {

    @Test
    void testFormat() {
        String[] values = {"foo", "bar", "baz"};
        CSVFormat format = new CSVFormat(',')
                .withEncapsulator('"')
                .withLineSeparator("\r\n");

        assertEquals("foo,bar,baz", format.format(values));
    }
}