package capm.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author deepak.jayaprakash
 */
@Data
public class MetaData implements Serializable {
    private static final long serialVersionUID = -3541316835254881665L;
    private String message;
    private ErrorCode errorCode;
}
