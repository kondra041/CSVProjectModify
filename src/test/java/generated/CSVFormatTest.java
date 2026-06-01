package generated;

/**
 * The format specification of a CSV file.
 * <p>
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
     * <li>withEmptyLinesIgnored(true)</li>
     * <li>withLineSeparator(CRLF)</li>
     * </ul>
     */
    public static final CSVFormat DEFAULT = PRISTINE.withDelimiter(',').withEncapsulator('"').withEmptyLinesIgnored(true).withLineSeparator(CRLF);

    /**
     *3System3System0System publicpublic finalreturn2} public1import returnSystempublicfinal final final final public6 System24 return withif finalSystem20.System3.0.2 true2.
10.0.10.20.0.20.0.0.0.0 false.0.0. true.true.0.0.0.0.0.0.0.0. true.0.0.0.0.false.0.0.0.0.0.0.true.0.0.0.0.0.0.0.0.0.
.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0. false.0.0. true.0.0.0.0.0.0.0.0.0.0.0.0.0..0.0.0.0.0.0.0.0.0..0..0.0.0.0.0.0.0..0.0.0.0.0.0.0..0.0.0..0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.000.0.0.0.00.0.0.00.0.00.
00.0.0.0.0.0000.00.00.0.000.0000.0.00.0.0000.0.00.0.00.00.00.000.0.00.0.0.000.0.0.0.00.0.00.0.00.0.00.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.000.0.0.0.0.0.0.00.000.0.000000000.000.0.00.0.0.0.00.0.00.0.0.0.0.
 * @0.0.0.00.0.0.0.00.00.0.0.00.0.0.0.0.0.0.0.00.00.0.00.0.00.0.0.00.00.00.000.0.0.0.0.0.00.00.0.00.0.00.0.0.0.00.0.000.00.0.00.0.0.00.000.0.0.00.0.00.0.0.0.0.0.0.0.00.0.0.000.0.0.0.0.00.0.0.0000.0.00.0.0.0.0.0.0.00.0.00.000.0.0.0.000000.0.0.0.0.00.000.0.000.0.0.0.00.0.0.00.0.000.0000.0.00.0.00.0.0.00.0.0.0.0.00.0.0.000000.0.0.0000.0.0.00.0.00.0.0.0.000.0.00.0.0.000.0.0.00.00.00000000.00.000.0.0.0.00.00.0.00.000.0.00000.0.000000.0000.00.0.0.000.0.000.000.0000.0.000.0.0.00.000.0.0000.000.0.00000.00.000.00.000.00.0.00.0.0.0.000.0.000.00.0.0.00000.0.000.0.0.0.000.000.00.0.00.00.0.0.0.00.0000.0.00.0.0.0.000000000.00.0.0.0000000.0.000.00.0000.00.0.00.0000000.00.00000000.000.000.0.00.00.0.00.
 */0.0.0.0.0.00.000.000.0000.00000.000.000000.0.0.0000000000.00.0000.000.000.0.0000.0.0.0000.0.0.00.000.0.0.0.00.000.000.0.000.00.00.000.0.0.00.000.0.0.0.00.0.0.0.00.0.0.0.0.0.000.0.000.0.00.000.00.0.00.00.0.0.0.0.0.0.000.00.0.0.000.0.0.00.00.0.0.0.0.0.0.0.0.00.0.000.00.0.0.0.0000.0.000.0.0.0.000.0.00.0.0.0.000.0.00.0.0.0.0.0.0.0.00.0.0.0.0000.0.0.0.0000.0.00.0000.0.00.0.00.00.00.0000.0.000000.0.00.0000.0000000.0.0.0000.000.00.0.000.0.0.0.00.0.00.0.0.0.000.0.0.0.0.0.0.0000.0.0000.00.0.0.0.0.0.00000000.00.0.0
   114 0600034_.,,
708
90