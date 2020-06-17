package capm.exceptions;

import capm.enums.ReturnCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author deepak.jayaprakash
 */
@Getter
@Setter
@ToString
public class ApplicationException extends Exception {
    private static final long serialVersionUID = -210208236512209934L;
    private ReturnCode returnCode;
    private String errorMessage;

    public ApplicationException(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

}
