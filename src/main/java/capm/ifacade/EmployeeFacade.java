package capm.ifacade;

import capm.dto.request.PunchInRequest;
import capm.dto.response.ResponseDTO;
import capm.exceptions.ApplicationException;

/**
 * @author deepak.jayaprakash
 */
public interface EmployeeFacade {
    ResponseDTO getDatesForEmployee();

    void punchInPreference(PunchInRequest punchInRequest) throws ApplicationException;
}
