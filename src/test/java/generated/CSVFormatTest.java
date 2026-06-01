```java
package generated;

//================ CLASS =================
/**
 * The format specification of a CSV file.
 *
 * This class is immutable.
 */
public class CSVFormat implements Serializable {

    /**
     * According to RFC 4180, line breaks are delimited by CRLF
     */
    private static final String CRLF = "\r\n";

    private final char delimiter;

    private final char encapsulator;

    private final char commentStart;

    private final char escape;

    // Should leading/trailing spaces be ignored around values?
    private final boolean surroundingSpacesIgnored;

    private final boolean emptyLinesIgnored;

    // for outputs
    private final String lineSeparator;

    private final String[] header;

    /**
     * Constant char to be used for disabling comments, escapes and encapsulation.
     * The value -2 is used because it won't be confused with an EOF signal (-1),
     * and because the unicode value FFFE would be encoded as two chars (using surrogates)
     * and thus there should never be a collision with a real text char.
     */
    static final char DISABLED = '\ufffe';

    /**
     * Starting format with no settings defined; used for creating other formats from scratch.
     */
    private static CSVFormat PRISTINE = new CSVFormat(DISABLED, DISABLED, DISABLED, DISABLED, false, false, null, null);

    /**
     * Standard comma separated format, as for {@link #RFC4180} but allowing blank lines.
     * <ul>
     * <li>withDelimiter(',')</li>
     * <li>withEncapsulator('"')</li>
     * <li>withEmptyLinesIgnored(true }System2SystemfinalSystem final finalifSystem final System @System if final0.0. System1 dSystem final final20.System true.v.0.0.0.1.0.0.0.0.0.0.0.0. true.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0...0.0. true.0.0...0.0.0.0.0......0.0..0.0...0.0.
.0..0.0.0....0.0..0..0.0.0.0.0.0.0.0.0.0.0.0..0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.false.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.
0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.System.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.System.0.0.0.0.0.0.0. System.0.0.00.000.0.0.00.0.0.0.0.0.0.0.0.000.0.0.0.0.000.0.0.0.0.00.0.00.00.0.000.0.00.0.00.0.0.00.0.0.00.0.00000.0.0.0.0.0.000.0.000.0.0.0.0.000.0.0.0.0.00.0.000.00.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.00.0.0.0.0.0.00.0.0.0.0.0.0.00.00.0.00.0.00.000.00.0.00.0.0.00.0.000.0.0.00.0.0.0000.0.0.000.0.000.00000.0.0.0.0.0.0.0.0.0.0.0.0000.00.0000.0.00.000.0.0.0.0.00.0.00.0.0.0.0.0.0.0.0.0.0.000.0.00.0.00.0.00.0.0.00.00.0.000.00.0.0.00.0.000.00.00.0.00.0.00000.0.00.0.0.000.0.0.00.0.00.00.00.0.00.0.00.00.0000.00.0.0000000.0.00.00.00.000.00.00.000.0.0000.00.0.0.0.00.0000000.0000.00.000.000.0.000.0.00.0.00.00.000.0.00000000.00000.0.0.00000.00.0.000.0.00000.0.00.00.000.0000.0.0.000.0.00.0.0.00.0000.0000000.0000.0.0000.0.0.00.00.00.0.0.0000000.000.0.00.0 = 0.0000000.000.000.0.000.786500.00000.00000 =..600.0000.00000000.000000000;0.000000.0.00.00.0000000000000.0.00000.0.0000000000.00.00.00000.0000.System.000.000.00.0.00.000.00000.0000.0.0.00000.0000.00.0.0.0.00.000.0.0.000000000.00000.0000.00000000.0.00.00.0000.0.0.0.000.0000.0.00.0.00.0.0.000000.00.0.0000.0.000.0.0.000.0.000.0.0.00.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.00.00.0.00.0.0.0.0.0.0.0.0.0.0.000.0.00.0.0.0.0.0.0.000000.00000.0.00000.0.000.0.00.0.0.0.0.00.000.00.0.000.0.00.00.0000000.0.00000000.000.00.000.00102
64000
   ',_
       
       
   1,00 =. 0
           0,73.100.	0:21.1.30
81._..0_
        }1,0=.706020	4 1.,10409
00.,,
   _ ,00207,02020:.1,50	00..00(7
       340.
':.(
.0.30080,2
.
22.0	00 ',.1113
;.3
   0
       00a.4
09800
27100
 {2.