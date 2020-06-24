package capm.facadeimpl;

import capm.dto.internal.EmployeeList;
import capm.dto.request.PunchInRequest;
import capm.dto.response.ResponseDTO;
import capm.enums.ReturnCode;
import capm.exceptions.ApplicationException;
import capm.ifacade.EmployeeFacade;
import capm.model.mysql.DateWiseAttendanceEntity;
import capm.model.mysql.EmployeeEntity;
import capm.service.ConfigService;
import capm.service.DateWiseAttendanceService;
import capm.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
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

    @Autowired
    private ConfigService configService;

    @Override
    public ResponseDTO getDatesForEmployee() {
        return null;
    }


    @Override
    public void punchInPreference(PunchInRequest punchInRequest) throws ApplicationException {
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(punchInRequest.getEmployeeId());
        DateWiseAttendanceEntity dateAttendance = dateWiseAttendanceService.getDateWiseAttendance(punchInRequest.getDate(),
                employeeEntity.getTeamEntity().getId());
        if (dateAttendance == null) {
            dateAttendance = dateWiseAttendanceService.createNewDateEntity(punchInRequest.getDate(),
                    employeeEntity.getTeamEntity());
            dateWiseAttendanceService.save(dateAttendance);
        } else {
            EmployeeList employeeList = dateWiseAttendanceService.getEmployeeList(dateAttendance);
            Integer limit = configService.getLimit(employeeEntity.getTeamEntity().getId());
            if (employeeList.getIdList().size() >= limit) {
                throw new ApplicationException(ReturnCode.EC_002);
            } else {

            }
        }

    }
}
