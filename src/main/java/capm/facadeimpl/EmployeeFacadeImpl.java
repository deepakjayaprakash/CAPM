package capm.facadeimpl;

import capm.dto.internal.DateList;
import capm.dto.internal.EmployeeList;
import capm.dto.request.PunchInRequest;
import capm.dto.response.ResponseDTO;
import capm.enums.PunchInType;
import capm.enums.ReturnCode;
import capm.exceptions.ApplicationException;
import capm.ifacade.EmployeeFacade;
import capm.model.mysql.DateWiseAttendanceEntity;
import capm.model.mysql.EmployeeAttendanceEntity;
import capm.model.mysql.EmployeeEntity;
import capm.service.ConfigService;
import capm.service.DateWiseAttendanceService;
import capm.service.EmployeeAttendanceService;
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

    @Autowired
    private ConfigService configService;

    @Autowired
    private EmployeeAttendanceService employeeAttendanceService;

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
            if (punchInRequest.getPunchInType() == PunchInType.ADD) {
                handleAddPreference(punchInRequest, employeeEntity, dateAttendance, employeeList);
            } else if (punchInRequest.getPunchInType() == PunchInType.REMOVE) {
                handleRemovePreference(punchInRequest, employeeEntity, dateAttendance, employeeList);
            }
        }
    }

    private void handleRemovePreference(PunchInRequest punchInRequest, EmployeeEntity employeeEntity
            , DateWiseAttendanceEntity dateAttendance, EmployeeList employeeList) {
        employeeList.getIdList().remove(employeeEntity.getId());
        dateAttendance.setEmployeeList(dateWiseAttendanceService.getEmployeeList(employeeList));
        dateWiseAttendanceService.save(dateAttendance);

        EmployeeAttendanceEntity ea = employeeAttendanceService.getEmployeeAttendanceEntity(employeeEntity.getId());
        DateList dateList = employeeAttendanceService.getDateList(ea.getDateList());
        dateList.getDateList().remove(punchInRequest.getDate());
        ea.setDateList(employeeAttendanceService.getDateList(dateList));
        employeeAttendanceService.save(ea);
    }

    private void handleAddPreference(PunchInRequest punchInRequest, EmployeeEntity employeeEntity, DateWiseAttendanceEntity dateAttendance, EmployeeList employeeList) throws ApplicationException {
        Integer limit = configService.getLimit(employeeEntity.getTeamEntity().getId());
        if (employeeList.getIdList().size() >= limit) {
            throw new ApplicationException(ReturnCode.EC_002);
        } else {
            employeeList.getIdList().add(employeeEntity.getId());
            dateAttendance.setEmployeeList(dateWiseAttendanceService.getEmployeeList(employeeList));
            dateWiseAttendanceService.save(dateAttendance);

            EmployeeAttendanceEntity ea = employeeAttendanceService.getEmployeeAttendanceEntity(employeeEntity.getId());
            DateList dateList = employeeAttendanceService.getDateList(ea.getDateList());
            dateList.getDateList().add(punchInRequest.getDate());
            ea.setDateList(employeeAttendanceService.getDateList(dateList));
            employeeAttendanceService.save(ea);
        }
    }
}
