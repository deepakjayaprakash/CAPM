package capm.facadeimpl;

import capm.dto.request.PunchInRequest;
import capm.dto.response.ResponseDTO;
import capm.ifacade.EmployeeFacade;
import capm.model.mysql.DateWiseAttendanceEntity;
import capm.model.mysql.EmployeeEntity;
import capm.service.DateWiseAttendanceService;
import capm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author deepak.jayaprakash
 */
@Component
public class EmployeeFacadeImpl implements EmployeeFacade {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DateWiseAttendanceService dateWiseAttendanceService;

    @Override
    public ResponseDTO getDatesForEmployee() {
        return null;
    }

    @Override
    public void punchInPreference(PunchInRequest punchInRequest) {
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(punchInRequest.getEmployeeId());
        DateWiseAttendanceEntity dateAttendance = dateWiseAttendanceService.getDateWiseAttendance(punchInRequest.getDate(),
                employeeEntity.getTeamEntity().getId());
        if (dateAttendance == null) {
            dateAttendance = dateWiseAttendanceService.createNewDateEntity(punchInRequest.getDate(),
                    employeeEntity.getTeamEntity());
            dateWiseAttendanceService.save(dateAttendance);
        }

    }
}
