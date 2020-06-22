package capm.ifacade;

import capm.dto.request.PunchInRequest;
import capm.dto.response.ResponseDTO;

/**
 * @author deepak.jayaprakash
 */
public interface EmployeeFacade {
    ResponseDTO getDatesForEmployee();

    void punchInPreference(PunchInRequest punchInRequest);
}
