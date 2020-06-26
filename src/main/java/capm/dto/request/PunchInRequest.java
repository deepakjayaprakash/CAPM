package capm.dto.request;

import capm.enums.PunchInType;
import lombok.Data;

import java.util.Date;

/**
 * @author deepak.jayaprakash
 */
@Data
public class PunchInRequest {
    private Long employeeId;
    private Date date;
    private PunchInType punchInType;
}
