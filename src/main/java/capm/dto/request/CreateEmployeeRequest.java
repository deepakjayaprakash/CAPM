package capm.dto.request;

import lombok.Data;

/**
 * @author deepak.jayaprakash
 */
@Data
public class CreateEmployeeRequest {
    private String name;
    private String code;
    private Long teamId;
}
