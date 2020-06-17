package capm.dto.request;

import lombok.Data;

/**
 * @author deepak.jayaprakash
 */
@Data
public class CreateTeamRequest {
    private String name;
    private Long managerId;
}
