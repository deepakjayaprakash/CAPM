package capm.dto.response;

import capm.enums.ReturnCode;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author deepak.jayaprakash
 */
@Data
@Builder
public class MetaDataDTO implements Serializable {
    private static final long serialVersionUID = -3541316835254881665L;
    private String message;
    private ReturnCode returnCode;
}
