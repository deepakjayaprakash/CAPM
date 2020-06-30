package capm.ifacade;

import capm.dto.request.PunchInRequest;
import capm.dto.response.EmpPrefDao;
import capm.dto.response.EmployeesOnDateResponse;
import capm.exceptions.ApplicationException;

import java.text.ParseException;

/**
 * @author deepak.jayaprakash
 */
public interface EmployeeFacade {

    void punchInPreference(PunchInRequest punchInRequest) throws ApplicationException;

    EmpPrefDao getEmployeePreference(Long id);

    EmployeesOnDateResponse getEmployeesOnDate(String date, Long teamId) throws ParseException;
}
