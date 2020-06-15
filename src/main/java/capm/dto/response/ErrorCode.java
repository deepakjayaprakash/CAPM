package capm.dto.response;

/**
 * @author deepak.jayaprakash
 */
public enum ErrorCode {
    EC_001("EC_001", "api failed");

    private final String code;
    private final String message;

    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
