package capm.ifacade;

import capm.dto.request.PunchInRequest;
import capm.dto.response.EmpPrefDao;
import capm.exceptions.ApplicationException;

/**
 * @author deepak.jayaprakash
 */
public interface EmployeeFacade {

    void punchInPreference(PunchInRequest punchInRequest) throws ApplicationException;

    EmpPrefDao getEmployeePreference(Long id);
}
